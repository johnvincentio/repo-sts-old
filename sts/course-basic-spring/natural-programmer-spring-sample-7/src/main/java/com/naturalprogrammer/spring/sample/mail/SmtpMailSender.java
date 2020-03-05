package com.naturalprogrammer.spring.sample.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Create an instance of MockMailSender and keep it somewhere

//Mimicking this class as a third party class
public class SmtpMailSender implements MailSender {

	private static final Log log = LogFactory.getLog(SmtpMailSender.class);

	private DemoObject demoObject;
	public void setDemoObject (DemoObject demoObject) {
		this.demoObject = demoObject;
	}

	@Override
	public void send(String to, String subject, String body) {
		// demoObject...
		log.info("Sending SMTP mail to " + to);
		log.info("Subject: " + subject);
		log.info("Body: " + body);
	}
}
