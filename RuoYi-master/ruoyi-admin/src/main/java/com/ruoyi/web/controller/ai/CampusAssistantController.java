package com.ruoyi.web.controller.ai;

import com.ruoyi.ai.service.CampusAssistantService;
import com.ruoyi.ai.service.DocumentIngestionService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/ai/assistant")
public class CampusAssistantController {

    private static final Logger log = LoggerFactory.getLogger(CampusAssistantController.class);

    @Autowired
    private CampusAssistantService assistantService;

    @Autowired
    private DocumentIngestionService ingestionService;

    @PostMapping("/chat")
    public AjaxResult chat(@RequestBody ChatRequest request) {
        try {
            if (request == null || request.getQuestion() == null || request.getQuestion().isBlank()) {
                return AjaxResult.error("问题不能为空");
            }
            log.info("收到聊天请求: {}", request.getQuestion());
            String answer = assistantService.answer(request.getQuestion());
            log.info("聊天响应成功");
            return AjaxResult.success(answer);
        } catch (Exception e) {
            log.error("聊天接口异常", e);
            return AjaxResult.error("服务异常: " + e.getMessage());
        }
    }

// ... existing code ...

    @PostMapping("/document/upload")
    public AjaxResult uploadDocument(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return AjaxResult.error("文件为空");
            }
            log.info("开始上传文档: {}", file.getOriginalFilename());
            ingestionService.ingest(file.getInputStream(), file.getOriginalFilename());
            log.info("文档上传成功");
            return AjaxResult.success("文档已成功导入知识库");
        } catch (Exception e) {
            log.error("文档上传失败", e);
            return AjaxResult.error("文档处理失败：" + e.getMessage());
        }
    }

    static class ChatRequest {
        private String question;
        public String getQuestion() { return question; }
        public void setQuestion(String question) { this.question = question; }
    }
}
