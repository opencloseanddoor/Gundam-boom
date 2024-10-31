package com.gundamBoom.spring.buy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gundamBoom.spring.admin.domain.Product;
import com.gundamBoom.spring.admin.dto.ProductView;
import com.gundamBoom.spring.admin.service.AdminService;
import com.gundamBoom.spring.buy.domain.ShoppingCart;
import com.gundamBoom.spring.buy.dto.ShoppingCartView;
import com.gundamBoom.spring.buy.service.BuyService;
import com.gundamBoom.spring.user.domain.User;
import com.gundamBoom.spring.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/buy")
public class BuyController 
{
	private AdminService adminService;
	private UserService userService;
	private BuyService buyService;
	
	public BuyController
	(
		UserService userService,
		AdminService adminService,
		BuyService buyService
	)
	{
		this.userService = userService;
		this.adminService = adminService;
		this.buyService = buyService;
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
	
	@GetMapping("/shopping-cart-view")
	public String shoppingCart
	(
		Model model,
		HttpSession session
	)
	{
		int userId = (Integer)session.getAttribute("userId");
		List<ShoppingCartView> shoppingCartList = buyService.searchShoppingCartList(userId);
		
		model.addAttribute("shoppingCartList", shoppingCartList);
		
		return "basic/shoppingCart";
	}
}
