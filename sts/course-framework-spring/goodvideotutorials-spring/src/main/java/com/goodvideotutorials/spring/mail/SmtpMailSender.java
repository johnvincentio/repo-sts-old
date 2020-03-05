package com.goodvideotutorials.spring.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SmtpMailSender implements MailSender {

	private static final Logger log = LoggerFactory.getLogger(SmtpMailSender.class);

	private JavaMailSender javaMailSender;
	
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/* (non-Javadoc)
	 * @see com.goodvideotutorials.spring.mail.MailSender#send(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void send(String to, String subject, String body) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;

		helper = new MimeMessageHelper(message, true); // true indicates
														// multipart message
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body, true); // true indicates html
		// continue using helper object for more functionalities like adding attachments, etc.  
		
		javaMailSender.send(message);

		log.info("Sending SMTP (99) mail to " + to);
		log.info("Subject: " + subject);
		log.info("Body: " + body);
	}
}
