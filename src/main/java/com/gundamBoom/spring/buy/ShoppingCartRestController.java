package com.gundamBoom.spring.buy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gundamBoom.spring.admin.service.AdminService;
import com.gundamBoom.spring.buy.domain.ShoppingCart;
import com.gundamBoom.spring.buy.service.BuyService;
import com.gundamBoom.spring.buy.service.ShoppingCartService;
import com.gundamBoom.spring.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartRestController 
{
	private ShoppingCartService shoppingCartService;
	
	public ShoppingCartRestController
	(
		UserService userService,
		AdminService adminService,
		BuyService buyService,
		ShoppingCartService shoppingCartService
	)
	{
		this.shoppingCartService = shoppingCartService;
	}
	
	@PostMapping("/shoppingCartAdd")
	public Map<String, String> ShoppingCartAdd
	(
		@RequestParam("productId") int productId,
		@RequestParam("count") int count,
		HttpSession session
	)
	{
		Map<String, String> resultMap = new HashMap<>();
		int userId = (Integer)session.getAttribute("userId");
		ShoppingCart shoppingCart = shoppingCartService.addShoppingCart(productId, userId, count);
		
		if(shoppingCart != null)
		{
			resultMap.put("result", "success");
		}
		else
		{
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@PostMapping("/deleteShoppingCart")
	public Map<String, String> deleteShoppingCart
	(
		@RequestParam("shoppingCartId") int shoppingCartId
	)
	{
		Map<String, String> resultMap = new HashMap<>();
		
		if(shoppingCartService.delete(shoppingCartId))
		{
			resultMap.put("result", "success");
		}
		else 
		{
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	@PostMapping("/allDeleteShoppingCart")
	public Map<String, String> allDeleteShoppingCart
	(
		@RequestParam("userId") int userId
	)	
	{
		Map<String, String> resultMap = new HashMap<>();
		
		if(shoppingCartService.allDelete(userId))
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
