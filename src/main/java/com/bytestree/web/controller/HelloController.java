package com.bytestree.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("message", "This is home page. It is accessible to all roles.");
		model.setViewName("home");
		
		return model;

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("message", "This page is accessible for Admin role !");
		model.setViewName("admin");

		return model;

	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDeniedPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("message", "You are not authorized to view this page.");
		model.setViewName("accessDenied");

		return model;

	}
	
	

}