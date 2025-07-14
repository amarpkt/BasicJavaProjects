package com.jobPortal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobPortal.model.User;
import com.jobPortal.repository.UserRepository;
import com.jobPortal.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void register(User user) {
		System.out.println("2");
		user.setEnabled(true);
		userRepository.save(user);
		
	}

	@Override
	public User login(String email, String password) {
		User user = userRepository.findByEmail(email);
		if(user!=null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
}
