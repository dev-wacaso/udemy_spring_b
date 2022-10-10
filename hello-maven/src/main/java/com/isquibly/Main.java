package com.isquibly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.debug("Hi DEBUG");
        logger.info("Hi INFO");
        System.out.println("Hello world!");
    }
}