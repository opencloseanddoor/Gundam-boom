package com.gundamBoom.spring.user.service;

import org.springframework.stereotype.Service;

import com.gundamBoom.spring.user.repository.UserRepository;

@Service
public class UserService 
{
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	public int addUser
	(
		String loginId,
		String password,
		String name,
		String address,
		String phoneNumber
	)
	{
		return userRepository.insertUser(loginId, password, name, address, phoneNumber);
	}
}