package com.example.task.service;

import java.util.List;

import com.example.task.entities.User;

public interface UserService {

	public List<User> getAllData();
	
	public User postAllData(User user);
	
}
