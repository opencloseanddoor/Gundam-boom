package com.gundamBoom.spring.user;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gundamBoom.spring.buy.dto.NormalUserView;
import com.gundamBoom.spring.buy.service.BuyService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/userPage")
public class UserPageController 
{
	private BuyService buyService;
	
	private UserPageController
	(
		BuyService buyService
	)
	{
		this.buyService = buyService;
	}
	
	
	@GetMapping("/userShoppingList")
	public String printUserPage	
	(
		Model model,
		HttpSession session
	)
	{
		int userId = (Integer)session.getAttribute("userId");
		
		List<NormalUserView> normalUserViewList = buyService.searchUserProduct(userId);
		
		model.addAttribute("userId", userId);
		model.addAttribute("normalUserViewList", normalUserViewList);
		
		return "basic/userPage";
	}
}