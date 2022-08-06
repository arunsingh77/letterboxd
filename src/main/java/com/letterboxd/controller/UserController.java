package com.letterboxd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letterboxd.model.User;
import com.letterboxd.service.UserService;

@RestController
@RequestMapping("/letterboxd")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable int userId) {
		return userService.getUser(userId);
	}
	
	@PostMapping("/user/adduser")
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PutMapping("/user/update/{userId}")
	public String updateUser(@PathVariable int userId,@RequestBody User user) {
		return userService.updateUser(user);
	}

}
