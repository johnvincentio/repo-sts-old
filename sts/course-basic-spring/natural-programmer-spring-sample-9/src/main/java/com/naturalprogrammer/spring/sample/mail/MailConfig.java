package com.naturalprogrammer.spring.sample.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;

// if @Component, DemoObject will be created 3 times.
@Configuration
public class MailConfig {

	@Bean
	@Profile("dev")		// when dev is an active profile
	public MailSender mockMailSender() {
		return new MockMailSender();
	}

	@Bean
	@Profile("!dev")
	public MailSender smtpMailSender(JavaMailSender javaMailSender) {
		SmtpMailSender mailSender = new SmtpMailSender();
		mailSender.setJavaMailSender(javaMailSender);
		return mailSender;
	}
}
