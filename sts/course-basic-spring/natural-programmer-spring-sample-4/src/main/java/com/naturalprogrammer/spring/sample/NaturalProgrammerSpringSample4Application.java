package com.naturalprogrammer.spring.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class NaturalProgrammerSpringSample4Application {

    public static void main(String[] args) {
        SpringApplication.run(NaturalProgrammerSpringSample4Application.class, args);
    }
}
