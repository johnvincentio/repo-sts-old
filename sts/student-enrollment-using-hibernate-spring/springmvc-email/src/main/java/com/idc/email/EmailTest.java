package com.idc.email;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailTest {

	@SuppressWarnings("resource")
	public static void main(String args[]) {

		// Spring Bean file you specified in /src/main/resources folder
		String configFile = "my-beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(configFile);

		// @Service("jvEmail") 
		EmailService emailService = (EmailService) context.getBean("jvEmail");
		String toAddr = "to@gmail.com";
		String fromAddr = "from@gmail.com";

		// email subject
		String subject = "Hey.. This email sent by JV Spring MVC Tutorial";

		// email body
		String body = "There you go.. You got an email.. Spring Email Framework";
		emailService.readyToSendEmail(toAddr, fromAddr, subject, body);
	}
}
