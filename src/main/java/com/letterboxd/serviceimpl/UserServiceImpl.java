package com.letterboxd.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letterboxd.dao.UserDao;
import com.letterboxd.model.User;
import com.letterboxd.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	@Override
	public String addUser(User user) {
		return userDao.addUer(user);
	}

	@Override
	public String updateUser(User user) {
		return userDao.updateUser(user);
	}

}
