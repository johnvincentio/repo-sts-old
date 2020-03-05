package com.naturalprogrammer.spring.sample.core;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturalprogrammer.spring.sample.mail.MailSender;

@RestController
public class MailController {

	private MailSender mailSender;
	
	@Autowired
	public MailController(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@RequestMapping("/mail")
	public String sendMail() throws MessagingException {
		
		mailSender.send("jv2351tech@gmail.com", "Some subject", "the content");
		
		return "Mail sent";
	}
}
