package com.idc.store;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packtpub.springmvc.chocolatestore.model.Customer;
import com.packtpub.springmvc.chocolatestore.model.Product;
import com.packtpub.springmvc.chocolatestore.model.service.CustomerService;
import com.packtpub.springmvc.chocolatestore.model.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	ProductService productService;

	@Autowired
	CustomerService customerService;

/**
 * Simply selects the home view to render by returning its name.

@CookieValue("JSESSIONID") String cookie == handle cookie
 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@CookieValue("JSESSIONID") String cookie, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);

		System.out.println("getFeaturedProducts");
		List<Product> featuredProducts = productService.getFeaturedProducts();

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("productList", featuredProducts);

		List<Customer> allCustomers = customerService.findAllCustomers();
		model.addAttribute("allCustomers", allCustomers);

		System.out.println("cookie :"+cookie+":");
		return "home";
	}
	
}
