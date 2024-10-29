package com.gundamBoom.spring.buy.service;

import org.springframework.stereotype.Service;

import com.gundamBoom.spring.buy.domain.ProductList;
import com.gundamBoom.spring.buy.domain.UserProduct;
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
		UserOrderListRepository userOrderListRepository
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
		return userOrderRepository.findByUserId(userId);
	}
}
