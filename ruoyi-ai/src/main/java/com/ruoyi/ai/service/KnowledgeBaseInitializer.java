package com.ruoyi.ai.service;// ... existing code ...
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.parser.apache.tika.ApacheTikaDocumentParser;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class KnowledgeBaseInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(KnowledgeBaseInitializer.class);

    @Value("${campus.docs.path:docs}")
    private String docsPath;

    @Autowired
    private EmbeddingModel embeddingModel;

    @Autowired
    private EmbeddingStore<TextSegment> embeddingStore;

    private final ExecutorService executor = Executors.newFixedThreadPool(
            Math.min(4, Runtime.getRuntime().availableProcessors())
    );

    @Override
    public void run(String... args) {
        Path docsDir = Paths.get(docsPath);
        if (!Files.exists(docsDir)) {
            try {
                Files.createDirectories(docsDir);
                log.info("已创建知识库文档目录: {}", docsDir.toAbsolutePath());
            } catch (Exception e) {
                log.error("创建文档目录失败", e);
            }
            return;
        }

        long startTime = System.currentTimeMillis();
        log.info("========== 开始初始化知识库 ==========");
        log.info("扫描目录: {}", docsDir.toAbsolutePath());

        try (Stream<Path> paths = Files.walk(docsDir)) {
            List<Path> files = paths.filter(Files::isRegularFile).toList();
            log.info("发现 {} 个文档文件", files.size());

            int totalSegments = 0;
            for (Path file : files) {
                int count = indexFile(file);
                totalSegments += count;
            }

            long elapsed = System.currentTimeMillis() - startTime;
            log.info("========== 知识库初始化完成 ==========");
            log.info("总共处理 {} 个有效片段，总耗时: {} 秒，平均每个片段: {} 毫秒",
                    totalSegments,
                    String.format("%.2f", elapsed / 1000.0),
                    totalSegments > 0 ? String.format("%.0f", (double) elapsed / totalSegments) : "N/A");
        } catch (Exception e) {
            log.error("遍历文档目录失败", e);
        }
    }

    private int indexFile(Path file) {
        try (InputStream is = Files.newInputStream(file)) {
            long fileStartTime = System.currentTimeMillis();
            log.info("开始处理文档: {}", file.getFileName());

            ApacheTikaDocumentParser parser = new ApacheTikaDocumentParser();
            Document document = parser.parse(is);
            List<TextSegment> segments = DocumentSplitters.recursive(500, 0).split(document);

            // 过滤有效片段
            List<TextSegment> validSegments = segments.stream()
                    .filter(segment -> !isInvalidSegment(segment))
                    .collect(Collectors.toList());

            int validCount = validSegments.size();
            log.info("文档 [{}] 提取 {} 个有效片段", file.getFileName(), validCount);

            if (validCount == 0) {
                log.info("文档 [{}] 无有效片段，跳过", file.getFileName());
                return 0;
            }

            // 并行生成 embeddings
            List<CompletableFuture<Void>> futures = new ArrayList<>();
            for (int i = 0; i < validSegments.size(); i++) {
                final int index = i;
                final TextSegment segment = validSegments.get(i);

                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                    long segmentStart = System.currentTimeMillis();
                    segment.metadata().put("file_name", file.getFileName().toString());
                    Embedding embedding = embeddingModel.embed(segment).content();
                    embeddingStore.add(embedding, segment);
                    long segmentElapsed = System.currentTimeMillis() - segmentStart;
                    log.debug("  [并行] 片段 #{} 向量化耗时: {} ms", index + 1, segmentElapsed);
                }, executor);

                futures.add(future);
            }

            // 等待所有任务完成
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

            long fileElapsed = System.currentTimeMillis() - fileStartTime;
            log.info("文档 [{}] 处理完成: 有效 {}/{} 片段，总耗时: {} 秒",
                    file.getFileName(), validCount, segments.size(),
                    String.format("%.2f", fileElapsed / 1000.0));

            return validCount;
        } catch (Exception e) {
            log.error("索引文档失败: " + file.getFileName(), e);
            return 0;
        }
    }

    private boolean isInvalidSegment(TextSegment segment) {
        String text = segment.text().trim();
        if (text.isEmpty() || text.length() < 10) {
            return true;
        }
        String lowerText = text.toLowerCase();
        if (lowerText.contains("content_types")
                || lowerText.contains("_rels")
                || lowerText.contains("docprops")
                || lowerText.contains("apache poi")
                || lowerText.startsWith("<?xml")
                || lowerText.matches("^<.*>$")
                || lowerText.contains("xmlns:")) {
            return true;
        }
        if (text.matches("^[\\s\\p{Punct}]+$")) {
            return true;
        }
        return false;
    }
}
