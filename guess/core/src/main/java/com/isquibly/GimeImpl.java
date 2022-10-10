package com.isquibly;

import com.isquibly.annotations.GuessCount;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Component("gime")
public class GimeImpl implements Gime {
    @Getter(AccessLevel.NONE)
    private NumberGenerator numGen;
//    private static final Logger log = LoggerFactory.getLogger(GimeImpl.class);

    private int guessCount;
    private int magicNumber, rangeLo, rangeHi, remainingGuesses;
    @Setter
    private int guess;
    private boolean isValidNumberRange = true;

    @Autowired
    public GimeImpl(NumberGenerator numGen, @GuessCount int guessCount) {
        this.numGen = numGen;
        this.guessCount = guessCount;
    }

    @PostConstruct
    @Override
    public void reset() {
        rangeLo = guess = numGen.getMinNumber();
        rangeHi = numGen.getMaxNumber();
        magicNumber = numGen.next();
        remainingGuesses = guessCount;
        log.info("the magicNumber is {}", magicNumber);
    }

    @PreDestroy
    public void cleanup() {
        log.info("Cleaning up before shutdown...");
    }

    @Override
    public void check() {
        checkValidNumberRange();
        if (isValidNumberRange) {

            if (guess == magicNumber) {

            } else if (guess > magicNumber) {
                rangeHi = guess - 1;
            } else {
                rangeLo = guess + 1;
            }
        }
        remainingGuesses -= 1;
    }

    @Override
    public boolean isGimeWon() {
        return guess == magicNumber;
    }

    @Override
    public boolean isGimeLost() {
        return !isGimeWon() && remainingGuesses <= 0;
    }

    private void checkValidNumberRange() {
        isValidNumberRange = guess >= rangeLo && guess <= rangeHi;
    }
}
