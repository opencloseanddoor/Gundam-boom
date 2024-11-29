package com.gundamBoom.spring.buy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gundamBoom.spring.admin.domain.Product;
import com.gundamBoom.spring.admin.service.AdminService;
import com.gundamBoom.spring.buy.domain.ShoppingCart;
import com.gundamBoom.spring.buy.dto.ShoppingCartView;
import com.gundamBoom.spring.buy.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService
{
	private ShoppingCartRepository shoppingCartRepository;
	private AdminService adminService;
	
	public ShoppingCartService
	(
		ShoppingCartRepository shoppingCartRepository,
		AdminService adminService
	)
	{
		this.shoppingCartRepository = shoppingCartRepository;
		this.adminService = adminService;
	}
	
	public ShoppingCart addShoppingCart
	(
		int productId,
		int userId,
		int count
	)
	{
		ShoppingCart shoppingCart = ShoppingCart
				.builder()
				.productId(productId)
				.userId(userId)
				.count(count)
				.build();
		
		ShoppingCart result = shoppingCartRepository.save(shoppingCart);
		
		return result;
	}
	
	public List<ShoppingCartView> searchShoppingCartView
	(
		int userId
	)
	{
		List<ShoppingCart> shoppingCartList = shoppingCartRepository.findAllByUserIdOrderByIdDesc(userId);
		List<ShoppingCartView> cartList = new ArrayList<>();
		
		for(ShoppingCart item : shoppingCartList)
		{			
			int productId = item.getProductId(); // ShoppingCartList에는 productId가 존재하므로 Product클래스를 가져오기 위한 id를 가져온다.
			
			Product product = adminService.getProduct(productId); //DTO클래스에 Product클래스를 넣기 위하여 해당 클래스를 가져온다.
			
			ShoppingCartView view = ShoppingCartView
					.builder()
					.id(item.getId())
					.productId(item.getProductId())
					.product(product)
					.imagePath(product.getImagePath())
					.userId(item.getUserId())
					.count(item.getCount())
					.build();
			
			cartList.add(view);
		}
	    
	    return cartList;
	}
	
	public boolean delete(int id)
	{
		Optional<ShoppingCart> optionalShoppingCart = shoppingCartRepository.findById(id);
		ShoppingCart shoppingCart = optionalShoppingCart.orElse(null);
		
		if(shoppingCart != null)
		{
			shoppingCartRepository.delete(shoppingCart);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Boolean allDelete(int userId)
	{
		List<ShoppingCart> shoppingCarts = shoppingCartRepository.findAllByUserId(userId);
		
		if(!shoppingCarts.isEmpty())
		{
			shoppingCartRepository.deleteAll(shoppingCarts);
			return true;
		}
		else
		{
			return false;
		}
	}
}
