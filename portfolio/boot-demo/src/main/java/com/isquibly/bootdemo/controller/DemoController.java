package com.isquibly.bootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class DemoController {
    @GetMapping("demo")
    @ResponseBody
    public String demo() {
        log.info("demo() called...");
        return "Hello Spring boot!";
    }

    @GetMapping("welcome")
    public String welcome(Model model) {
        log.info("welcome method called...");
        model.addAttribute("message", "Message set on Model in DemoController...");
        return "messageView";
    }
}
