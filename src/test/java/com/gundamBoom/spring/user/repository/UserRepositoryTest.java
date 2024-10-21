package com.gundamBoom.spring.user.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gundamBoom.spring.user.domain.User;

import jakarta.transaction.Transactional;

class UserRepositoryTest 
{
	@Autowired
	private UserRepository userRepository;
	
	@Test
	@Transactional
	public void selectUserTest()
	{
		// given
		String loginId = "asm2007";
		String password = "as201088!";
		
		// when 
		User user1 = userRepository.selectUser(loginId, password);
		User user2 = userRepository.selectUser(loginId, null);
		
		
		// then
		assertNotNull(user1);
		assertNotNull(user2);
	}

}
