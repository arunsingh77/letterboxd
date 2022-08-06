package com.letterboxd.service;

import com.letterboxd.model.User;

public interface UserService {

	User getUser(int userId);
	String addUser(User user);
	String updateUser(User user);

}
