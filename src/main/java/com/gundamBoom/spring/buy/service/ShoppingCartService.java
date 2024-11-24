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
	
	public List<Product> searchProductList
	(
		int userId
	)
	{
		List<ShoppingCart> shoppingCartList = shoppingCartRepository.findAllByUserIdOrderByIdDesc(userId);
		List<Product> productList = new ArrayList<>();
		
		for(ShoppingCart item : shoppingCartList)
		{			
			int productId = item.getProductId();
			
			Product product = adminService.getProduct(productId);
			
			productList.add(product);
		}
	    
	    return productList;
	}
	
	public List<ShoppingCartView> searchShoppingCartList
	(
		int userId
	)
	{
		List<ShoppingCart> shoppingCartList = shoppingCartRepository.findAllByUserIdOrderByIdDesc(userId);
		List<ShoppingCartView> viewList = new ArrayList<>();
		
		for(ShoppingCart item : shoppingCartList)
		{
			ShoppingCartView view = ShoppingCartView
					.builder()
					.id(item.getId())
					.productId(item.getProductId())
					.userId(item.getUserId())
					.count(item.getCount())
					.build();
			
			viewList.add(view);
		}
		return viewList;		
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
}
