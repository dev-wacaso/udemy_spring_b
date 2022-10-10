package com.isquibly;

import com.isquibly.config.GimeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@Slf4j
public class Main {
//    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
//        ConfigurableApplicationContext ctx =  new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        log.trace("Start testRandomNumber()");
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(GimeConfig.class);
        ctx.close();
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