package com.goodvideotutorials.spring.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockMailSender implements MailSender {

	private static final Logger log = LoggerFactory.getLogger(MockMailSender.class);

	/* (non-Javadoc)
	 * @see com.goodvideotutorials.spring.mail.MailSender#send(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending mail to " + to);
		log.info("Subject: " + subject);
		log.info("Body: " + body);
	}
}
