package com.learning.SpringSecurity.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
	
	@GetMapping("/")
	public String homePage() {
		return "Hello Satyanvesh";
	}

	@GetMapping("/application")
	public String myApplication(HttpServletRequest request) {
		return "Spring Security " + request.getSession().getId();
	}
}
