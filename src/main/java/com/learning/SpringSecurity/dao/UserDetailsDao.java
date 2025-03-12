package com.learning.SpringSecurity.dao;

import com.learning.SpringSecurity.domain.User;

public interface UserDetailsDao {

	public User getUserDetailsByUserName(String userName);
	
	public User register(User user);
}
