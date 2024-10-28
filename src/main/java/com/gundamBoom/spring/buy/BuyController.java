package com.gundamBoom.spring.buy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gundamBoom.spring.admin.domain.Product;
import com.gundamBoom.spring.admin.service.AdminService;

@Controller
@RequestMapping("/buy")
public class BuyController 
{
	private AdminService adminService;
	
	public BuyController(AdminService adminService)
	{
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
		Model model
	)
	{
		model.addAttribute("productId", productId);
		
		return "basic/importBuy";
	}
}
