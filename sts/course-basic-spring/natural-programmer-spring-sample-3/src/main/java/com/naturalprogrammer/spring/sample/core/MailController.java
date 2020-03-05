package com.naturalprogrammer.spring.sample.core;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturalprogrammer.spring.sample.mail.MailSender;

@RestController
public class MailController {

// Tell Spring to go look for an object of type MailSender

// Can explicitly ask for a bean name here or could set Component name (see SmtpMailSender)
//	@Resource(name="smtpMailSender")
	@Resource
	private MailSender mailSender;
	
	@RequestMapping("/mail")
	public String sendMail() {
		mailSender.send ("any@mail.com", "Subject", "Content");
		return "Mail sent";
	}
}
