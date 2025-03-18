package com.learning.SpringSecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learning.SpringSecurity.dao.UserDetailsDao;
import com.learning.SpringSecurity.domain.User;
import com.learning.SpringSecurity.domain.UserPrincipal;

@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserDetailsDao userDetailsDao;

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userDetailsDao.getUserDetailsByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found!");
		}
		return new UserPrincipal(user);
	}

}
