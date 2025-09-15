package com.tka.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		// get current time in yyyy-mm-dd HH:MM:SS
		String createdAtt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		user.setCreatedAt(createdAtt);
		int status = dao.registerUser(user);
		
		// mail sending
		return status;
	}

	@Override
	public List<User> allUser() {
		List<User> list = dao.allUser();
		return list;
	}

	@Override
	public boolean deleteUser(int id) {

		return dao.deleteUser(id);
	}

	@Override
	public User getUser(int id) {

		return dao.getUser(id);
	}

	@Override
	public boolean updateProfile(User user) {
		
		return dao.updateProfile(user);
	}

}
