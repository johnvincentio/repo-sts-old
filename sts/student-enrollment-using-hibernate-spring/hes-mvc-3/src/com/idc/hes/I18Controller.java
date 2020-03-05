package com.idc.hes;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.idc.hes.model.Person;

@Controller
@RequestMapping("/i18")
public class I18Controller {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String  home() {
		return "redirect:/i18/user";
	}

	@RequestMapping(value="/user", method = RequestMethod.GET)
	public ModelAndView user(Locale locale) {
		return new ModelAndView("i18/userform", "user", new Person());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String  save(@ModelAttribute("user") Person user) {
		return "i18/success";
	}
}
