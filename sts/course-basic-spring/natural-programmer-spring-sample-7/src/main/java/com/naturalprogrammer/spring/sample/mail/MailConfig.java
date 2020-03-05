package com.naturalprogrammer.spring.sample.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// if @Component, DemoObject will be created 3 times.
@Configuration
public class MailConfig {

//	@Autowired
//	private DemoObject demoObject;

	@Bean
	// @Profile("dev")		// when dev is an active profile
	public MailSender mockMailSender() {
		MockMailSender mailSender = new MockMailSender();
		mailSender.setDemoObject(demoObject());
		return mailSender;
	}

	@Bean
	// @Profile("!dev")
	@Primary
	public MailSender smtpMailSender(DemoObject demoObject) {
		SmtpMailSender mailSender = new SmtpMailSender();
		mailSender.setDemoObject(demoObject);
		return mailSender;
	}
	
	@Bean
	public DemoObject demoObject() {		// function is only run once
		return new DemoObject();
	}
}
