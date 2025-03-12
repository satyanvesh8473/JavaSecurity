package com.learning.SpringSecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.SpringSecurity.domain.User;
import com.learning.SpringSecurity.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		System.out.println("user: " + user);
		return userService.register(user);
	}

	@PostMapping("/login")
	public String login(@RequestBody User user) {
		System.out.println("User: " + user);
		return userService.verify(user);
	}
}
