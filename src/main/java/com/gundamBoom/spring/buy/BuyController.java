package com.gundamBoom.spring.buy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gundamBoom.spring.admin.domain.Product;
import com.gundamBoom.spring.admin.service.AdminService;
import com.gundamBoom.spring.user.domain.User;
import com.gundamBoom.spring.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/buy")
public class BuyController 
{
	private AdminService adminService;
	private UserService userService;
	
	public BuyController
	(
		UserService userService,
		AdminService adminService
	)
	{
		this.userService = userService;
		this.adminService = adminService;
	}
	
	@GetMapping("/purchase-view/{productId}")
	public String productPurchase
	(
		@PathVariable("productId") int productId,
		Model model
	)
	{
		Product product = adminService.getProduct(productId);
		model.addAttribute("product", product);
		
		return "basic/purchase";
	}
	
	@GetMapping("/orderPage-view/{productId}")
	public String userOrder
	(
		@PathVariable("productId") int productId,
		Model model
	)
	{
		model.addAttribute("productId", productId);
		
		return "basic/orderPage";
	}
	
	@GetMapping("/importBuy/{productId}")
	public String importBuy
	(
		@PathVariable("productId") int productId,
		Model model,
		HttpSession session
	)
	{
		String loginId = (String)session.getAttribute("loginId");
		
		User user = userService.selectUserByLoginId(loginId);
		Product product = adminService.getProduct(productId);
		model.addAttribute("user", user);
		model.addAttribute("product", product);
		
		return "basic/importBuy";
	}
}
