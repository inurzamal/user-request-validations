package com.nur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nur.dto.UserRequest;
import com.nur.entity.User;
import com.nur.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(UserRequest userRequest) {
		User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
		return userRepository.save(user);
	}
	
	@Override
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@Override
	public User getUser(int id) {
		Optional<User> optional = userRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		return null;
	}
	
	@Override
	public User getUser(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public String deleteUser(int id) {		
		userRepository.deleteById(id);
		return "Contact deleted successfully";
	}

}
