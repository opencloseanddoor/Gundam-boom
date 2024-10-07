package com.gundamBoom.spring.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gundamBoom.spring.user.domain.User;
import com.gundamBoom.spring.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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
	
	@PostMapping("/login")
	public Map<String, String> login
	(
		@RequestParam("loginId") String loginId,
		@RequestParam("password") String password,
		HttpServletRequest request
	)
	{
		User user = userService.searchUser(loginId, password);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(user != null)
		{
			resultMap.put("result", "success");
			
			HttpSession session = request.getSession(); //세션의 관한 정보를 받아옵니다
			
			session.setAttribute("userId", user.getId()); //세션에 id를 userId라는 이름으로 등록을 합니다, 이 값을 가지고 다른 페이지에서 사용을 합니다
			session.setAttribute("name", user.getName()); //세션에 사용자 이름을 등록을 합니다
		}
		
		else
		{
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/isDuplicate")
	public Map<String, Boolean> isDuplicate
	(
		@RequestParam("loginId") String loginId
	)
	{
		boolean isDuplicate = userService.isDuplicate(loginId);
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
		resultMap.put("isDuplicate", isDuplicate);
		
		return resultMap;
	}
}
