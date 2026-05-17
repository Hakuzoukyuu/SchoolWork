package com.ruoyi.ai.service;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.parser.apache.tika.ApacheTikaDocumentParser;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.file.*;
import java.util.List;
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

        try (Stream<Path> paths = Files.walk(docsDir)) {
            paths.filter(Files::isRegularFile)
                    .forEach(this::indexFile);
            log.info("知识库初始化完成");
        } catch (Exception e) {
            log.error("遍历文档目录失败", e);
        }
    }

    private void indexFile(Path file) {
        try (InputStream is = Files.newInputStream(file)) {   // 用 InputStream 打开文件
            ApacheTikaDocumentParser parser = new ApacheTikaDocumentParser();
            Document document = parser.parse(is);             // 传入输入流
            List<TextSegment> segments = DocumentSplitters.recursive(500, 0).split(document);
            for (TextSegment segment : segments) {
                segment.metadata().put("file_name", file.getFileName().toString());
                Embedding embedding = embeddingModel.embed(segment).content();
                embeddingStore.add(embedding, segment);
            }
            log.info("已索引文档: {}", file.getFileName());
        } catch (Exception e) {
            log.error("索引文档失败: " + file.getFileName(), e);
        }
    }
}