package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@GetMapping("/greeting")
	public ModelAndView greetingMessage() {
		
		System.out.println("anananan");

		ModelAndView mav = new ModelAndView();

		String message = "Welcome to Trisect";

		mav.addObject("message", message);
		mav.setViewName("welcome");

		return mav;

	}

}
