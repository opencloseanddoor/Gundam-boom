package com.gundamBoom.spring.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController 
{
	@GetMapping("/list-view")
	public String list()
	{
		return "admin/adminPage";
	}
}
