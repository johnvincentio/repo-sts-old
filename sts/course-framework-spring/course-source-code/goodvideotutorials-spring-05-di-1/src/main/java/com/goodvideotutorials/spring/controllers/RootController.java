package com.goodvideotutorials.spring.controllers;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodvideotutorials.spring.mail.MailSender;
import com.goodvideotutorials.spring.mail.MockMailSender;

@RestController
public class RootController {
	
	@Resource
	private MailSender mailSender;
	
	@RequestMapping("/")
	public String home() {
		
		mailSender.send("abc@example.com", "Hello, World", "Mail from spring");		
		return "Hello, world";
		
	}

}
