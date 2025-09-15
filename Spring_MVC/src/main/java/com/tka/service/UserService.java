package com.tka.service;

import java.util.List;

import com.tka.entity.User;

public interface UserService {
	
	public User loginUser(String username,String password);
	public int registerUser(User user);
	
	public List<User> allUser();
	public boolean deleteUser(int id);
	
	public User getUser(int id);
	public boolean updateProfile(User user);

}
