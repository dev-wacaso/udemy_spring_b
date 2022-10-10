package com.isquibly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main_usingXMLConfig {
    private static final Logger log = LoggerFactory.getLogger(Main_usingXMLConfig.class);
    private static final String CONFIG_LOCATION = "beans.xml.txt";

    public static void main(String[] args) {
        log.info("Take a guess");
        System.out.println("Hello world!");

        ConfigurableApplicationContext ctx =  new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        testRandomNumber(ctx);
        ctx.close();
    }

    private static void testRandomNumber(ConfigurableApplicationContext ctx) {
        log.trace("Start testRandomNumber()");
        NumberGenerator numGen = ctx.getBean("numberGenBean", NumberGenerator.class);
        int number = numGen.next();
        log.info("numGen() test number = {}", number);
        log.trace("End testRandomNumber()");

        Gime gime = ctx.getBean("gimeBean", Gime.class);
        gime.reset();



    }
}