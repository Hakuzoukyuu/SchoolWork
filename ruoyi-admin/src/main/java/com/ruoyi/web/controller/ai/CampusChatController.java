package com.ruoyi.web.controller.ai;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ai/chat")
public class CampusChatController {

    @GetMapping("/page")
    public String chatPage() {
        return "campus/chat";   // 对应 templates/campus/chat.html
    }
}