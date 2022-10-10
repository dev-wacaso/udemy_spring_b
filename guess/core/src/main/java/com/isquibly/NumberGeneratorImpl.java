package com.isquibly;

import com.isquibly.annotations.MaxNumber;
import com.isquibly.annotations.MinNumber;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Component("numberGenerator")
public class NumberGeneratorImpl implements NumberGenerator {
    @Getter(AccessLevel.NONE)
    private final Random random = new Random();
    private int minNumber;
    private int maxNumber;

    @Autowired
    public NumberGeneratorImpl(@MinNumber int minNumber, @MaxNumber int maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    @Override
    public int next() {
        return minNumber + random.nextInt(maxNumber - minNumber);
    }
}
