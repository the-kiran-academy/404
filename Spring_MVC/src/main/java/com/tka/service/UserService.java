package com.tka.service;

import java.util.List;

import com.tka.entity.User;

public interface UserService {
	
	public User loginUser(String username,String password);
	public int registerUser(User user);
	
	public List<User> allUser();

}
