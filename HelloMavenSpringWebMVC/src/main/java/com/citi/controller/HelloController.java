
package com.citi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HelloController {
	
	LoginInfo logininfo=new LoginInfo();
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	
	public String index(@RequestParam("t1")String uname,@RequestParam("t2")String pass) {
		System.out.println("Username:"+uname);
		System.out.println("Password:"+pass);
		
		logininfo.setPassword(pass);
		logininfo.setUsername(uname);
		//model.addAttribute("message", "Hello Spring WEB MVC!");
		return "hello";
	}

	

}
