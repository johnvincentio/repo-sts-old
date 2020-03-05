package com.packtpub.springmvc.chocolatestore.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.packtpub.springmvc.chocolatestore.config.ApplicationConfig;

public class TestApp {

	public static void main(String[] args) {
		(new TestApp()).doit();
	}

	private void doit() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AppImpl obj = (AppImpl) context.getBean("myApp");
//		obj.doit_1();
//		obj.doit_2();
//		obj.doit_3();
		obj.doit_4();
		obj.doit_5();
	}
}
