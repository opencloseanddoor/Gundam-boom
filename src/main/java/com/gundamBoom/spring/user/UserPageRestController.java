package com.gundamBoom.spring.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gundamBoom.spring.buy.service.BuyService;

@RestController
@RequestMapping("userPageRestController")
public class UserPageRestController 
{
	private BuyService buyService;
	
	private UserPageRestController
	(
		BuyService buyService
	)
	{
		this.buyService = buyService;
	}
	
	@PostMapping("deleteUserProduct")
	public Map<String, String> deleteUserProduct
	(
		@RequestParam("userProductId") int userProductId
	)
	{
		Map<String, String> resultMap = new HashMap<>();
		
		if(buyService.deleteUserProduct(userProductId))
		{
			resultMap.put("result", "success");
		}
		
		else
		{
			resultMap.put("result", "success");
		}
		
		return resultMap;
	}
	
}