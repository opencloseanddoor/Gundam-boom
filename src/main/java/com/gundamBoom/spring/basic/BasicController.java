package com.gundamBoom.spring.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic")
public class BasicController 
{
	@GetMapping("/main-view")
	public String mainPage()
	{
		return "/basic/main";
	}
}
