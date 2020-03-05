package com.naturalprogrammer.spring.sample.core;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturalprogrammer.spring.sample.mail.MailSender;

@RestController
public class MailerController {

// Tell Spring to go look for an object of type MailSender

// Can explicitly ask for a bean name here or could set Component name (see SmtpMailSender)
//	@Resource(name="smtpMailSender")
//	@Resource
	private MailSender mailSender;

// @Autowired is preferred

	@Autowired
	public MailerController (MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@RequestMapping("/mailer")
	public String sendMail() throws MessagingException {
		mailSender.send("jv2351tech@gmail.com", "Some subject", "the content");
		return "(900) Mailer sent";
	}
}
