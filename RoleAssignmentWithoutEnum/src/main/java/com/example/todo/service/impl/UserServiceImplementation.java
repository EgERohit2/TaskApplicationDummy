package com.example.todo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.entities.Role;
import com.example.todo.entities.User;
import com.example.todo.entities.UserDto;
import com.example.todo.repository.RoleRepository;
import com.example.todo.repository.UserRepository;
import com.example.todo.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public User updateUser(int id, User user) {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		// TODO Auto-generated method stub
//		Optional<User> optionalUser = userRepository.findById(id);
		User optionalUser = userRepository.findByIdAndIsActiveTrue(id).orElseThrow();

//			User existingUser = optionalUser.get();
		optionalUser.setName(user.getName());
		optionalUser.setEmail(user.getEmail());
		optionalUser.setPsk(user.getPsk());
		optionalUser.setMob(user.getMob());
//			existingUser.setUsertask(user.getUsertask());
		return userRepository.save(optionalUser);
	}

//	@Override
//	public List<UserDto> converEntitytoDto() {
//		List<User> u = userRepository.findAll();
//		List<UserDto> userDto = new ArrayList<>();
//		for (int i = 0; i < userDto.size(); i++) {
//			UserDto ud = new UserDto();
//			ud.setEmail(u.get(i).getEmail());
//			ud.setMob(u.get(i).getMob());
//			ud.setName(u.get(i).getName());
//			ud.setPsk(u.get(i).getPsk());
//			userDto.add(ud);
//
//		}
//		return userDto;
//	}

	@Override
	public UserDto converEntitytoDto(User user) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		UserDto userDto = new UserDto();
		userDto = modelMapper.map(user, UserDto.class);

		return userDto;
	}

	@Override
	public List<UserDto> getAllUserDto() {
		// TODO Auto-generated method stub
		return userRepository.findAll().stream().map(this::converEntitytoDto).collect(Collectors.toList());
	}

	@Override
	public void addRoles(int userId, int roleId) {
		// TODO Auto-generated method stub
		User u = userRepository.findById(userId).orElseThrow();
		Role r = roleRepository.findById(roleId).orElseThrow();

		List<Role> userRole = u.getRole();
		userRole.add(r);
		u.setRole(userRole);
		userRepository.save(u);

	}

}
