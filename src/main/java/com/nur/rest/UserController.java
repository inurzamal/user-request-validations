package com.nur.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nur.dto.UserRequest;
import com.nur.entity.User;
import com.nur.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<User> createUser(@RequestBody @Valid UserRequest userRequest){
		User status = userService.saveUser(userRequest);
		return new ResponseEntity<>(status, HttpStatus.CREATED);	
	}
	
	@GetMapping("/allusers")
	public ResponseEntity<List<User>> getAllUsers(){
//		List<User> users = userService.getAllUsers();
//		return new ResponseEntity<>(users,HttpStatus.OK);
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id){
		return ResponseEntity.ok(userService.getUser(id));
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email){
		return ResponseEntity.ok(userService.getUser(email));
	}

}
