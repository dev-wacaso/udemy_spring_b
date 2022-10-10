package com.isquibly;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess /*implements ApplicationListener<ContextRefreshedEvent>*/ {
//    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);
    private Gime gime;
    private MessageGenerator messageGenerator;

    @Autowired
    public ConsoleNumberGuess(MessageGenerator messageGenerator, Gime gime) {
        this.messageGenerator = messageGenerator;
        this.gime = gime;

        log.info("ConsoleNumberGuess()  called...");
    }

//    @Override
    @EventListener
    public void startGame(ContextRefreshedEvent event) {
        log.info("Container ready for use!!!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());
            int guess = scanner.nextInt();
            scanner.nextLine();
            gime.setGuess(guess);
            gime.check();

            if (gime.isGimeWon() || gime.isGimeLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n?");

                String playAgainString = scanner.nextLine().trim();
                if (!playAgainString.equalsIgnoreCase("y")) {
                    break;
                }

                gime.reset();
            }
        }
    }
}
