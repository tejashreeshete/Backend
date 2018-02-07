
package com.citi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller


public class HelloController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	
	public String index(ModelMap model) {
		model.addAttribute("message", "Hello Spring WEB MVC!");
		return "hello";
	}

}
