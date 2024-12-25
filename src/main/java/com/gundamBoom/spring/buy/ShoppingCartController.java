package com.gundamBoom.spring.buy;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gundamBoom.spring.buy.dto.ShoppingCartView;
import com.gundamBoom.spring.buy.service.BuyService;
import com.gundamBoom.spring.buy.service.ShoppingCartService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController 
{
	private ShoppingCartService shoppingCartService;
	
	public ShoppingCartController
	(
		BuyService buyService,
		ShoppingCartService shoppingCartService
	)
	{
		this.shoppingCartService = shoppingCartService;
	}	

	@GetMapping("/shopping-cart-view")
	public String shoppingCart
	(
		Model model,
		HttpSession session
	)
	{
		int userId = (Integer)session.getAttribute("userId");
		List<ShoppingCartView> shoppingCartList = shoppingCartService.searchShoppingCartView(userId);
		
		model.addAttribute("userId", userId);
		model.addAttribute("shoppingCartList", shoppingCartList);
		
		return "basic/shoppingCart";
	}
}
