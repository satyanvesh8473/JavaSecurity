package com.learning.SpringSecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.SpringSecurity.dao.UserDetailsDao;
import com.learning.SpringSecurity.domain.User;

@Service
public class UserService {
	@Autowired
	private UserDetailsDao userDetailsDao;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTService jwtService;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	public User register(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userDetailsDao.register(user);
	}

	public String verify(User user) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUserName());
		}
		return "Failure";
	}
}
