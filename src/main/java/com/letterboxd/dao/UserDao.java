package com.letterboxd.dao;

import com.letterboxd.model.User;

public interface UserDao {

	User getUser(int userId);
	String addUer(User user);
	String updateUser(User user);

}
