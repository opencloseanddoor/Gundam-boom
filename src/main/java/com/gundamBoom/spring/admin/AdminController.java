package com.gundamBoom.spring.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gundamBoom.spring.admin.domain.Product;
import com.gundamBoom.spring.admin.dto.ProductView;
import com.gundamBoom.spring.admin.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController 
{
	private AdminService adminService;
	
	public AdminController(AdminService adminService)
	{
		this.adminService = adminService;
	}
	
	@GetMapping("/list-view")
	public String list
	(
		Model model
	)
	{
		List<ProductView> productViewList = adminService.getProductList();
		
		model.addAttribute("productViewList", productViewList);
		
		return "admin/adminPage";
	}
	
	@GetMapping("/insert-view")
	public String insert()
	{
		return "admin/insertPage";
	}
	
	@GetMapping("/modify-view/{productId}")
	public String modify
	(
		@PathVariable("productId") int productId,
		Model model
	)
	{
		Product product = adminService.getProduct(productId);
		
		
		model.addAttribute(product);
			
		return "admin/modify";
	}
}
