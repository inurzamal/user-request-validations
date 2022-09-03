package com.nur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nur.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

}
