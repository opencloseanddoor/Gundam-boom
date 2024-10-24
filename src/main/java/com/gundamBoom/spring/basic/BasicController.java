package com.gundamBoom.spring.basic;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gundamBoom.spring.admin.domain.Product;
import com.gundamBoom.spring.admin.dto.ProductView;
import com.gundamBoom.spring.admin.service.AdminService;
import com.gundamBoom.spring.user.service.UserService;

@Controller
@RequestMapping("/basic")
public class BasicController 
{	
	private UserService userService;
	private AdminService adminService;
	
	public BasicController
	(
		UserService userService,
		AdminService adminService
	)
		
	{
		this.userService = userService;
		this.adminService = adminService;
	}
	
	@GetMapping("/mainPage-view")
	public String main
	(
		Model model
	)
	{
		List<ProductView> productViewList = adminService.getProductList();
		
		model.addAttribute("productViewList", productViewList);
		
		return "basic/main";
	}
	
	@GetMapping("/category-view/{category}")
	public String category
	(
		@PathVariable("category") String category,
		Model model
	)
	{
		List<ProductView> productViewList = adminService.getProductListByCategory(category);
		
		model.addAttribute("productViewList", productViewList);
		
		return "basic/category";
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
	
	@GetMapping("/orderPage-view")
	public String userOrder()
	{
		return "basic/orderPage";
	}
}