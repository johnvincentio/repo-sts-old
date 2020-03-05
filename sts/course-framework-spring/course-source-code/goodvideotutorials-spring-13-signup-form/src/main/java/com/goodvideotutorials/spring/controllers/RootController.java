package com.goodvideotutorials.spring.controllers;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.goodvideotutorials.spring.dto.SignupForm;
import com.goodvideotutorials.spring.mail.MailSender;
import com.goodvideotutorials.spring.mail.MockMailSender;

@Controller
public class RootController {
	
	private static final Logger logger = LoggerFactory.getLogger(RootController.class);
	
	private MailSender mailSender;
	
	@Autowired
	public RootController(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
//	@RequestMapping("/")
//	public String home() throws MessagingException {
//		
//		//mailSender.send("abc@example.com", "Hello, World", "Mail from spring");		
//		return "home";
//		
//	}
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		
		model.addAttribute(new SignupForm());
		
		return "signup";
		
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute("signupForm") SignupForm signupForm) {
		
		logger.info(signupForm.toString());
		
		return "redirect:/";

	}


}
