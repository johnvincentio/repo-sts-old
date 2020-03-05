package com.goodvideotutorials.spring.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodvideotutorials.spring.mail.MailSender;

@RestController
public class RootController {

	private MailSender mailSender;

	@Autowired
	public RootController(MailSender mailSender) {
		this.mailSender = mailSender;	
	}

	@RequestMapping("/")
	public String home() throws MessagingException {
		mailSender.send("jv2351tech@gmail.com", "some subject", "some body");
		return "Hello Somebody";
	}
}
