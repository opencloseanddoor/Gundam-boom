package com.gundamBoom.spring.buy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gundamBoom.spring.buy.domain.UserProduct;

public interface UserOrderRepository extends JpaRepository<UserProduct, Integer> 
{	
	public UserProduct findByUserId(int userId);
}