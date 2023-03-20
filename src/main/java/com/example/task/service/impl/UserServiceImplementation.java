package com.example.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.entities.User;
import com.example.task.repository.UserRepository;
import com.example.task.service.UserService;
@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllData() {
		// TODO Auto-generated method stub
		return userRepository.findAll() ;
	}

	@Override
	public User postAllData(User user) {
		User u = new User();
		u.setEmail(user.getEmail());
		u.setMob(user.getMob());
		u.setPassword(user.getPassword());
		u.setRole(user.getRole());
		return userRepository.save(u);
	}

}
