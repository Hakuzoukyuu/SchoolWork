package com.ruoyi.ai.service;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentParser;
import dev.langchain4j.data.document.parser.apache.tika.ApacheTikaDocumentParser;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.InputStream;
import java.util.List;

@Service
public class DocumentIngestionService {

    private static final Logger log = LoggerFactory.getLogger(DocumentIngestionService.class);

    @Autowired
    private EmbeddingModel embeddingModel;

    @Autowired
    private EmbeddingStore<TextSegment> embeddingStore;

    public void ingest(InputStream inputStream, String fileName) {
        DocumentParser parser = new ApacheTikaDocumentParser();
        Document document = parser.parse(inputStream);

        List<TextSegment> segments = DocumentSplitters.recursive(500, 0).split(document);

        int validCount = 0;
        for (TextSegment segment : segments) {
            // 过滤无效元数据片段
            if (isInvalidSegment(segment)) {
                continue;
            }
            segment.metadata().put("file_name", fileName);
            Embedding embedding = embeddingModel.embed(segment).content();
            embeddingStore.add(embedding, segment);
            validCount++;
        }
        log.info("文档【{}】入库完成，有效文本片段：{} 个", fileName, validCount);
    }

    /**
     * 过滤无效片段（DOCX元数据、空文本、纯符号、XML标签）
     */
    private boolean isInvalidSegment(TextSegment segment) {
        String text = segment.text().trim();
        // 规则1：空/极短片段
        if (text.isEmpty() || text.length() < 10) {
            return true;
        }
        // 规则2：过滤DOCX内部元数据
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
        // 规则3：纯符号/空白文本
        if (text.matches("^[\\s\\p{Punct}]+$")) {
            return true;
        }
        return false;
    }
}