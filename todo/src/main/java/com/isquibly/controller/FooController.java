package com.isquibly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class FooController {
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "ola!";
    }

    @GetMapping("/")
    public void handleDefault(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(200);
        resp.getWriter().println("apple");
    }

    @GetMapping("/todo")
    public void handleTodo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(200);
        resp.getWriter().println("blueberry");
    }
}
