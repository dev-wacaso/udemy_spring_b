package com.isquibly.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService{
    @Override
    public String getHelloMessage(String username, int age) {
        return "Hello " + username + "(" + age + ")";
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this Demo application";
    }
}
