package com.naturalprogrammer.spring.sample.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

// @Autowired if preferred

	@Autowired
	public MailerController (@Qualifier ("smtpMailSender") MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@RequestMapping("/mailer")
	public String sendMail() {
		mailSender.send ("any@mail.com", "Subject", "Content");
		return "(3) Mailer sent";
	}
}
