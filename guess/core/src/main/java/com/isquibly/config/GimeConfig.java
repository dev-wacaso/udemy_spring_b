package com.isquibly.config;

import com.isquibly.annotations.GuessCount;
import com.isquibly.annotations.MaxNumber;
import com.isquibly.annotations.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.isquibly")
@PropertySource("classpath:config/gime.properties")
public class GimeConfig {
    @Value("${game.minNumber:10}")
    private int minNumber;

    @Value("${game.maxNumber:20}")
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean()
    @GuessCount
    public int guessCount2() {
        return guessCount;
    }
}
