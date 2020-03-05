package com.idc.store;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packtpub.springmvc.chocolatestore.model.Customer;
import com.packtpub.springmvc.chocolatestore.model.service.CustomerService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	CustomerService customerService;

/*
Model model == use if need to add attribute.
 */
	@RequestMapping(params = "register")
	public String createForm(Model model) {
		model.addAttribute("user", new Customer());
		return "user/register";
	}

/*
@ModelAttribute("user") == modelAttribute="user" in register.jsp
Customer customer = populate the Customer object from "user"
@Valid Customer customer == apply validation
BindingResult result == any errors
*/
	@RequestMapping(method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") @Valid Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return "user/register";
		}
		customerService.saveCustomer(customer);
		return "redirect:/users/" + customer.getName();	// ex: store/users/charlie
	}

/*
@PathVariable String userId for @RequestMapping(value = "/{userId}")
Map<String, Object> model for 
 */
	@RequestMapping(value = "/{userId}")
//	public String getUserProfile(@PathVariable String userId, Model model) {
	public String getUserProfile(@PathVariable String userId, Map<String, Object> model) {
		System.out.println("userId :"+userId+":");
		Customer customer = customerService.findCustomer(userId);
		model.put("user", customer);
//		model.addAttribute("user", customer);
		return "user/view";
	}

	@RequestMapping(value = "/{userId}/edit", method = RequestMethod.GET)
	public String editUserProfile(@PathVariable("userId") String userId, Map<String, Object> model) {
		Customer customer = customerService.findCustomer(userId);
		model.put("user", customer);
		return "user/edit";
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") @Valid Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return "user/register";
		}
		customerService.updateCustomer(customer);
		return "redirect:/users/" + customer.getName();
	}
}
