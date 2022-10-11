package com.isquibly.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {
    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("onStartup called....");

        // Create the web application context/Spring container

        // Create the Spring application context
        log.trace("creating/registering AnnotationConfigWebApplicationContext....");
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfig.class);

        // Create the dispatcher servlet
        log.trace("creating DispatcherServlet....");
        DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);

        // Register and configure the dispatcher servlet with the ServletContext/Container
        log.trace("add DispatcherServlet to ServletContext....");
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
