package com.gundamBoom.spring.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gundamBoom.spring.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestcontroller 
{
	private UserService userService;
	
	public UserRestcontroller(UserService userService)
	{
		this.userService = userService;
	}
	
	@PostMapping("/join")
	public Map<String, String> join
	(
		@RequestParam("loginId") String loginId,
		@RequestParam("password") String password,
		@RequestParam("name") String name,
		@RequestParam("address") String address,
		@RequestParam("phoneNumber") String phoneNumber
	)
	{
		int count = userService.addUser(loginId, password, name, address, phoneNumber);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1)
		{
			resultMap.put("result", "success");
		}
		else
		{
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
}
