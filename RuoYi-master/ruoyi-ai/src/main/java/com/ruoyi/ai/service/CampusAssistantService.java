package com.ruoyi.ai.service;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingSearchRequest;
import dev.langchain4j.store.embedding.EmbeddingSearchResult;
import dev.langchain4j.store.embedding.EmbeddingStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CampusAssistantService {

    private static final Logger log = LoggerFactory.getLogger(CampusAssistantService.class);

    @Autowired
    private EmbeddingModel embeddingModel;

    @Autowired
    private EmbeddingStore<TextSegment> embeddingStore;

    @Autowired
    private ChatLanguageModel chatModel;

    public String answer(String question) {
        try {
            log.info("收到学生问题: {}", question);

            Embedding queryEmbedding = embeddingModel.embed(question).content();
            log.debug("问题向量化完成");

            EmbeddingSearchRequest searchRequest = EmbeddingSearchRequest.builder()
                    .queryEmbedding(queryEmbedding)
                    .maxResults(3)
                    .minScore(0.6)
                    .build();
            EmbeddingSearchResult<TextSegment> result = embeddingStore.search(searchRequest);
            log.info("检索到 {} 个相关文档", result.matches().size());

            String context = result.matches().stream()
                    .map(m -> m.embedded().text())
                    .collect(Collectors.joining("\n\n"));

            String prompt;
            if (context.isEmpty()) {
                log.warn("未找到相关知识，使用通用对话模式");
                prompt = """
                    你是一位亲切、耐心的校园辅导员，正在和一位学生进行对话。
                    当前知识库中没有与该问题相关的文档，请基于你的常识友好地回答学生。
                    
                    要求：
                    - 语言要温和，可以使用"同学你好～""请先""别忘了"等亲切用语。
                    - 如果是校园相关问题，可以给出一般性建议。
                    - 如果是问候或闲聊，请友好回应。
                    - 如果确实无法回答，请建议学生联系相关部门或上传相关文档到知识库。
                    
                    学生问题：%s
                    回答：
                    """.formatted(question);
            } else {
                log.debug("检索到的上下文: {}", context.substring(0, Math.min(200, context.length())));
                prompt = """
                    你是一位亲切、耐心的校园辅导员，正在和一位学生进行对话。
                    请根据下面的学校规章制度，用易懂、友好的口语化方式来回答学生的问题。
                    
                    要求：
                    - 如果已知信息能回答，请分点简洁地说明关键步骤，避免直接复制长段落。
                    - 如果已知信息里缺少某些细节，请明确告知，并建议向班主任或学生处咨询。
                    - 语言要温和，可以使用"同学你好～""请先""别忘了"等亲切用语。
                    - 禁止编造未在已知信息中出现的规定。
                    
                    已知信息：
                    %s
                    
                    学生问题：%s
                    回答：
                    """.formatted(context, question);
            }

            String answer = chatModel.generate(prompt);
            log.info("AI 回答生成完成");
            return answer;

        } catch (Exception e) {
            log.error("处理问题时发生错误: {}", question, e);
            throw new RuntimeException("AI 服务处理失败: " + e.getMessage(), e);
        }
    }
}
