package com.goodvideotutorials.spring;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GoodvideotutorialsSpringApplication {
	
	private static final Logger log = LoggerFactory.getLogger(GoodvideotutorialsSpringApplication.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(GoodvideotutorialsSpringApplication.class, args);
        
        log.info("Beans in application context");
        String beanNames[] = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
        	log.info("Bean "+beanName);
        }
    }
}
