package com.naturalprogrammer.spring.sample.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Create an instance of MockMailSender and keep it somewhere

// Mimicking this class as a third party class
public class MockMailSender implements MailSender {

	private static final Log log = LogFactory.getLog(MockMailSender.class);

	private DemoObject demoObject;
	public void setDemoObject (DemoObject demoObject) {
		this.demoObject = demoObject;
	}

	/* (non-Javadoc)
	 * @see com.naturalprogrammer.spring.sample.mail.MailSender#send(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending mail to " + to);
		log.info("Subject: " + subject);
		log.info("Body: " + body);
	}
}
