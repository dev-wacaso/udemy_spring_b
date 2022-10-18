package com.isquibly;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Main {

    public static void main(String[] args) {
        log.trace("Start testRandomNumber()");
        SpringApplication.run(Main.class, args);
    }

/*
    private static void testRandomNumber(ConfigurableApplicationContext ctx) {
        log.trace("Start testRandomNumber()");
        NumberGenerator numGen = ctx.getBean("numberGenerator", NumberGenerator.class);//'"numberGenBean", NumberGenerator.class);
        int number = numGen.next();
        log.info("numberGenerator test number = {}", number);
        log.trace("End testRandomNumber()");

        Gime gime = ctx.getBean("gime", com.isquibly.Gime.class);
        gime.reset();

        MessageGenerator msgGen = ctx.getBean("messageGenerator", MessageGenerator.class);
        log.info("message from MessageGenerator.getMainMessage(): {}", msgGen.getMainMessage());
        log.info("message from MessageGenerator.getResultMessage(): {}", msgGen.getResultMessage());
    }
*/
}