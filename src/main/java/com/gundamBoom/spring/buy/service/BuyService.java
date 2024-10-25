package com.gundamBoom.spring.buy.service;

import org.springframework.stereotype.Service;

import com.gundamBoom.spring.buy.domain.UserProduct;
import com.gundamBoom.spring.buy.repository.UserOrderRepository;

@Service
public class BuyService
{
	private UserOrderRepository userOrderRepository;
	
	public BuyService
	(
		UserOrderRepository userOrderRepository
	)
	{
		this.userOrderRepository = userOrderRepository;
	}
	
	public UserProduct selectUser
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
}
