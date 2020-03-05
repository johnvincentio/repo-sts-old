package com.idc.hello.boot;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	HelloProperties props;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/hello-1")
	public String hello1(@RequestParam(value = "name", defaultValue = "World") String name) {
		return props.getGreeting() + name;
	}

	@RequestMapping("/hello-2")
	public Greeting hello2(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template,name));
	}
}