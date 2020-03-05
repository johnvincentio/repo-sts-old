package com.idc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idc.config.ApplicationConfig;

public class SpringOrmMain {

	public static void main(String[] args) {
		(new SpringOrmMain()).doit();
	}

	private void doit() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        AppImpl obj = (AppImpl) context.getBean("myApp");
        obj.doit_1();
		obj.doit_2();
		obj.doit_3();
	}
}
