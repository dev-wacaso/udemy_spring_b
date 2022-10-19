package com.isquibly.service;

import com.isquibly.Gime;
import com.isquibly.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GimeServiceImpl implements GimeService {
    private final Gime gime;
    private final MessageGenerator msgGen;

    @Autowired
    public GimeServiceImpl(Gime gime, MessageGenerator msgGen) {
        this.gime = gime;
        this.msgGen = msgGen;
    }

//    @PostConstruct
//    void init() {
//        log.info("In the GimeServiceImpl...\n\tmain message: " + msgGen.getMainMessage() + "\n\tnumber to guess: " + gime.getMagicNumber());
//    }

    @Override
    public boolean isGimeOver() {
        return gime.isGimeWon() || gime.isGimeLost();
    }

    @Override
    public String getMainMessage() {
        return msgGen.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return msgGen.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        gime.setGuess(guess);
        gime.check();
    }

    @Override
    public void reset() {
        gime.reset();
    }
}
