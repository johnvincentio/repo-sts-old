package com.naturalprogrammer.spring.sample.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Create an instance of MockMailSender and keep it somewhere

/*
 * @Component has bean name mailSender.
 * If multiple mailSender, need to differentiate.
 * @Component("mailSender")
 * 
 * @Primary indicates primary bean
 */
// @Component
//@Component("mailSender")

@Component
@Primary
public class SmtpMailSender implements MailSender {

	private static final Log log = LogFactory.getLog(SmtpMailSender.class);

	/* (non-Javadoc)
	 * @see com.naturalprogrammer.spring.sample.mail.MailSender#send(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending SMTP mail to " + to);
		log.info("Subject: " + subject);
		log.info("Body: " + body);
	}
}
