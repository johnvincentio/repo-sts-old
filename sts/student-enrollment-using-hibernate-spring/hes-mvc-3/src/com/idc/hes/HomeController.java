package com.idc.hes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(value = "/test-1", method = RequestMethod.GET)
	@ResponseBody
	public String showIndex() {
		return "Just for testing...";
	}

	@RequestMapping(value = "/test-2")
	public String test(Model model) {
		return "test";
	}

	@RequestMapping(value = "")
	public String home(Model model) {
		return "home";
	}
}
