package com.nur.service;

import java.util.List;

import com.nur.dto.UserRequest;
import com.nur.entity.User;

public interface UserService {
	
	public User saveUser(UserRequest userRequest);
	public List<User> getAllUsers();
	public User getUser(int id);
	public User getUser(String email);
	public String deleteUser(int id);

}
