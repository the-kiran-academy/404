package com.tka.dao;

import java.util.List;

import com.tka.entity.User;

public interface UserDao {

	public User loginUser(String username, String password);

	public int registerUser(User user);

	public List<User> allUser();

	public boolean deleteUser(int id);

	public User getUser(int id);

	public boolean updateProfile(User user);

}
