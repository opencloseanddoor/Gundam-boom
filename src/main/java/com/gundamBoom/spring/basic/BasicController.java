package com.gundamBoom.spring.basic;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gundamBoom.spring.admin.dto.ProductView;
import com.gundamBoom.spring.admin.service.AdminService;

@Controller
@RequestMapping("/basic")
public class BasicController 
{	
	private AdminService adminService;
	
	public BasicController
	(
		AdminService adminService
	)
		
	{
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
		
		return "basic/purchase";
	}
}