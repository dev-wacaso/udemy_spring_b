package com.isquibly.controller;

import com.isquibly.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Slf4j
public class DemoController {
    private final DemoService demoService;
    @Autowired
    public DemoController(DemoService service) {
        this.demoService = service;
    }
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "ola!";
    }

//    @GetMapping("/")
//    public void handleDefault(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.setStatus(200);
//        resp.getWriter().println("Demo controller apple");
//    }
//
//    @GetMapping("/todo")
//    public void handleTodo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.setStatus(200);
//        resp.getWriter().println("blueberry");
//    }

    @GetMapping("/welcome")
    public String handleWelcome(@RequestParam String username, @RequestParam int age,  Model model) {
        model.addAttribute("helloMessage", demoService.getHelloMessage(username,age));
        log.info("handleWelcome(Model): " + model);
        return "welcomeView";
    }

    @ModelAttribute("welcomeMessage")
//    @ModelAttribute // uses the lowercase version of return type, ie, "string"
    public String welcomeMessage2() {
        log.info("welcomeMessage()");
        return demoService.getWelcomeMessage();
    }
}
