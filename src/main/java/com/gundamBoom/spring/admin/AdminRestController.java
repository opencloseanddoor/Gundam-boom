package com.gundamBoom.spring.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gundamBoom.spring.admin.domain.Product;
import com.gundamBoom.spring.admin.service.AdminService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminRestController 
{
	private AdminService adminService;
	
	public AdminRestController(AdminService adminService)
	{
		this.adminService = adminService;
	}
	
	@PostMapping("/add")
	public Map<String, String> addProduct
	(
		@RequestParam("name") String name,
		@RequestParam("menufacturer") String menufacturer,
		@RequestParam("price") String price,
		@RequestParam("imageFile") MultipartFile imageFile,
		@RequestParam("category") String category,
		@RequestParam("division") String division
	)
	{
		Product product = adminService.insertProduct(name, menufacturer, price, imageFile, category, division);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(product != null)
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