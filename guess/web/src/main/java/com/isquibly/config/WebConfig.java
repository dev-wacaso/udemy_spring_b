package com.isquibly.config;

import com.isquibly.util.WebViewNames;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(WebViewNames.HOME);
        registry.addViewController("home").setViewName(WebViewNames.HOME);
        registry.addViewController("/cart").setViewName(WebViewNames.CART);
    }
}
