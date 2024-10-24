package com.gundamBoom.spring.user.service;

import org.springframework.stereotype.Service;

import com.gundamBoom.spring.user.domain.User;
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
	
	public User searchUser
	(
		String loginId,
		String password
	)
	{
		return userRepository.selectUser(loginId, password);
	}
	
	//Overloading
	public User searchUser(String loginId)
	{
		return userRepository.selectUser(loginId);
	}
	
	public boolean isDuplicate(String loginId)
	{
		int count = userRepository.selectCountByLoginId(loginId);
		
		if(count == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
