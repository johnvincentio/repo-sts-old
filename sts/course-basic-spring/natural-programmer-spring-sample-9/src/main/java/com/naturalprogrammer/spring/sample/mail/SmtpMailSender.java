package com.naturalprogrammer.spring.sample.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

// Create an instance of SmtpMailSender and keep it somewhere

//Mimicking this class as a third party class
public class SmtpMailSender implements MailSender {

	private static final Log log = LogFactory.getLog(SmtpMailSender.class);

	private JavaMailSender javaMailSender;
	public void setJavaMailSender (JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void send(String to, String subject, String body) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body, true);

		javaMailSender.send(message);

		log.info("Sending SMTP mail to " + to);
		log.info("Subject: " + subject);
		log.info("Body: " + body);
	}
}
