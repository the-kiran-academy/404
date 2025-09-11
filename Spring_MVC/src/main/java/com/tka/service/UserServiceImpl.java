package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.UserDao;
import com.tka.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public User loginUser(String username, String password) {
		User user = dao.loginUser(username, password);

		return user;
	}

	@Override
	public int registerUser(User user) {
		int status = dao.registerUser(user);
		return status;
	}

	@Override
	public List<User> allUser() {
		List<User> list=dao.allUser();
		return list;
	}

}
