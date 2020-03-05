package com.naturalprogrammer.spring.sample.core;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturalprogrammer.spring.sample.mail.MailSender;
import com.naturalprogrammer.spring.sample.mail.MockMailSender;

@RestController
public class MailController {

	private MailSender mailSender = new MockMailSender();
	
	@RequestMapping("/mail")
	public String sendMail() {
		mailSender.send ("any@mail.com", "Subject", "Content");
		return "Mail sent";
	}
}
