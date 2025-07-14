package com.jobPortal.service;


import com.jobPortal.model.User;

public interface UserService {
	public void register(User user);
	public User login(String email, String password);
	public User fetchUser(String email);
	public void addLoginDetails(User user);

}
