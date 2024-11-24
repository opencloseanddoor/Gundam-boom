package com.gundamBoom.spring.buy;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gundamBoom.spring.admin.domain.Product;
import com.gundamBoom.spring.buy.dto.ShoppingCartView;
import com.gundamBoom.spring.buy.service.BuyService;
import com.gundamBoom.spring.buy.service.ShoppingCartService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController 
{
	private ShoppingCartService shoppingCartService;
	
	public ShoppingCartController
	(
		BuyService buyService,
		ShoppingCartService shoppingCartService
	)
	{
		this.shoppingCartService = shoppingCartService;
	}	

	@GetMapping("/shopping-cart-view")
	public String shoppingCart
	(
		Model model,
		HttpSession session
	)
	{
		// 아래의 코드에서 상품 정보를 조회하는 기능을 구현되었음
		// 하지만 상품의 수량을 조회하는 기능은 구현이 안 되었으므로 수량을 갖고있는 테이블을 이용해서 수량을 조회하자.
		int userId = (Integer)session.getAttribute("userId");
		List<Product> productList = shoppingCartService.searchProductList(userId);
		List<ShoppingCartView> shoppingCartList = shoppingCartService.searchShoppingCartList(userId);
		
		model.addAttribute("userId", userId);
		model.addAttribute("productList", productList);
		model.addAttribute("shoppingCartList", shoppingCartList);
		
		return "basic/shoppingCart";
	}
}
