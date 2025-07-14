package com.jobPortal.service;


import com.jobPortal.model.User;

public interface UserService {
	public void register(User user);
	public User login(String email, String password);

}
