package com.gundamBoom.spring.buy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gundamBoom.spring.buy.domain.ProductList;
import com.gundamBoom.spring.buy.domain.UserProduct;
import com.gundamBoom.spring.buy.service.BuyService;
import com.gundamBoom.spring.user.service.UserService;

import jakarta.servlet.http.HttpSession;

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
		@RequestParam("name") String name,
		@RequestParam("address") String address,
		@RequestParam("phoneNumber") String phoneNumber,
		@RequestParam("status") String status,
		@RequestParam("productId") int productId,
		HttpSession session
	)
	{
		Map<String, String> resultMap = new HashMap<>();
		
		int userId = (Integer)session.getAttribute("userId");
		
		UserProduct userProduct = buyService.insertUser(userId, name, address, phoneNumber, status);
		
		int userProductId = userProduct.getId();
		int count = 1;
		
		ProductList productList = buyService.insertProductList(userProductId, productId, count);
				
		if(userProduct != null && productList != null)
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
