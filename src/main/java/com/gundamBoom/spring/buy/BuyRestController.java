package com.gundamBoom.spring.buy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gundamBoom.spring.buy.domain.UserProduct;
import com.gundamBoom.spring.buy.service.BuyService;
import com.gundamBoom.spring.user.domain.User;
import com.gundamBoom.spring.user.service.UserService;

@RestController
@RequestMapping("/buy")
public class BuyRestController 
{
	private UserService userService;
	private BuyService buyService;
	
	public BuyRestController
	(
		UserService userService,
		BuyService buyService
	)
	{
		this.userService = userService;
		this.buyService = buyService;
	}
	
	@PostMapping("/purchaseDelivery")
	public Map<String, String> userPurchaseDelivery
	(
		@RequestParam("loginId") String loginId,
		@RequestParam("name") String name,
		@RequestParam("address") String address,
		@RequestParam("phoneNumber") String phoneNumber,
		@RequestParam("status") String status
	)
	{
		Map<String, String> resultMap = new HashMap<>();
		
		User user =  userService.searchUser(loginId);
		int userId = user.getId();
		UserProduct userProduct = buyService.selectUser(userId, name, address, phoneNumber, status);
		
		if(userProduct != null)
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
