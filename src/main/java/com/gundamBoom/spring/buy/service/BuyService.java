package com.gundamBoom.spring.buy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gundamBoom.spring.admin.service.AdminService;
import com.gundamBoom.spring.buy.domain.ProductList;
import com.gundamBoom.spring.buy.domain.ShoppingCart;
import com.gundamBoom.spring.buy.domain.UserProduct;
import com.gundamBoom.spring.buy.dto.ShoppingCartView;
import com.gundamBoom.spring.buy.dto.UserProductView;
import com.gundamBoom.spring.buy.repository.ShoppingCartRepository;
import com.gundamBoom.spring.buy.repository.UserOrderListRepository;
import com.gundamBoom.spring.buy.repository.UserOrderRepository;

@Service
public class BuyService
{
	private UserOrderRepository userOrderRepository;
	private UserOrderListRepository userOrderListRepository;
	
	public BuyService
	(
		UserOrderRepository userOrderRepository,
		UserOrderListRepository userOrderListRepository,
		ShoppingCartRepository shoppingCartRepository,
		AdminService adminService
	)
	{
		this.userOrderRepository = userOrderRepository;
		this.userOrderListRepository = userOrderListRepository;
	}
	
	public UserProduct insertUser
	(
		int userId,
		String name,
		String address,
		String phoneNumber,
		String status
	)
	{
		UserProduct userProduct = UserProduct
				.builder()
				.userId(userId)
				.name(name)
				.address(address)
				.phoneNumber(phoneNumber)
				.status(status)
				.build();
		
		UserProduct result = userOrderRepository.save(userProduct);
		
		return result;
	}
	
	public ProductList insertProductList
	(
		int userProductId,
		int productId,
		int count
	)
	{
		ProductList productList = ProductList
				.builder()
				.userProductId(userProductId)
				.productId(productId)
				.count(count)
				.build();
		
		ProductList result = userOrderListRepository.save(productList);
		
		return result;
	}
	
	public UserProduct findUserProduct(int userId)
	{
		return userOrderRepository.findTopByUserIdOrderByIdDesc(userId);
	}
	
	public List<UserProductView> searchListByUserProduct(int userId)
	{
		List<UserProduct> userProductList = userOrderRepository.findAllByUserId(userId);
		List<UserProductView> userProductListView = new ArrayList<>();
		
		for(UserProduct item : userProductList)
		{
			UserProductView view = UserProductView
					.builder()
					.userId(userId)
					.name(item.getName())
					.phoneNumber(item.getPhoneNumber())
					.address(item.getAddress())
					.status(item.getStatus())
					.build();
			userProductListView.add(view);
		}
		
		return userProductListView;
	}
}
