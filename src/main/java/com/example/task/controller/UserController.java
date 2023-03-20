package com.example.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.entities.User;
import com.example.task.service.impl.UserServiceImplementation;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImplementation userServiceImplementation;
	
	@PostMapping()
	public String postData(@RequestBody User user ) {
		userServiceImplementation.postAllData(user);
		return "posted";
	}
	
	@GetMapping()
	public List<User> getData(){
		return userServiceImplementation.getAllData();
	}
}
