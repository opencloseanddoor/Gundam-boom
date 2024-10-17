package com.gundamBoom.spring.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@GetMapping("/modify-view/{productId}")
	public String modify
	(
		@PathVariable("productId") int productId,
		HttpServletRequest request,
		Model model
	)
	{
		
		return "admin/modify";
	}
}
