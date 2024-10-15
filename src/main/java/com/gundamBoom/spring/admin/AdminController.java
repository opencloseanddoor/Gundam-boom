package com.gundamBoom.spring.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gundamBoom.spring.admin.dto.ProductView;
import com.gundamBoom.spring.admin.service.AdminService;

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
	
	@GetMapping("/category-view")
	public String categoryPg
	(
		Model model
	)
	{
		List<ProductView> productViewList = adminService.getProductList();
		
		model.addAttribute("productViewList", productViewList);
		
		return "basic/category";
	}
}
