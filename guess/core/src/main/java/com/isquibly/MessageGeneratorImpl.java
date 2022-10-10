package com.isquibly;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component("msgGenerator")
public class MessageGeneratorImpl implements MessageGenerator {
//    private final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
    @Getter
    private final Gime gime;

    @Autowired
    public MessageGeneratorImpl(Gime gime) {
        this.gime = gime;
    }

    @PostConstruct
    public void init() {
//        log.info("gime: " + gime);
    }

    @Override
    public String getMainMessage() {
        return "Number is between " + gime.getRangeLo() + " and " + gime.getRangeHi() + ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (gime.isGimeWon()) {
            return "You guessed it! The number was " + gime.getMagicNumber();
        }
        else if (gime.isGimeLost()) {
            return "You lost! The number was " + gime.getMagicNumber();
        }
        else if (!gime.isValidNumberRange()) {
            return "Invalid number range!";
        }
        else if (gime.getRemainingGuesses() == gime.getGuessCount()) {
            return "What is your first guess?";
        }
        else {
            String direction = "Lower";
            if (gime.getGuess() < gime.getMagicNumber()) {
                direction = "Higher";
            }

            return direction + "! You have " + gime.getRemainingGuesses() + " guess(es) left!";
        }
    }
}
