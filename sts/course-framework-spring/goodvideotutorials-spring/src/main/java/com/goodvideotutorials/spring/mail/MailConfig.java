package com.goodvideotutorials.spring.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

	@Bean
	public MailSender mockMailSender() {
		return new MockMailSender();
	}

	@Bean
	@Primary
	public MailSender smtpMailSender(JavaMailSender javaMailSender) {
		SmtpMailSender mailSender = new SmtpMailSender();
		mailSender.setJavaMailSender(javaMailSender);
		return mailSender;
	}
}
