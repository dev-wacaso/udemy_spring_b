package com.isquibly.bootdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BootDemoApplication {

	public static void main(String[] args) {
//		log.info("Inside BootDemoApplication()...");
		SpringApplication.run(BootDemoApplication.class, args);
	}

}
