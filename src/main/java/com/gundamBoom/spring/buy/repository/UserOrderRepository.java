package com.gundamBoom.spring.buy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gundamBoom.spring.buy.domain.UserProduct;

public interface UserOrderRepository extends JpaRepository<UserProduct, Integer> 
{	
	public UserProduct findTopByUserIdOrderByIdDesc(int userId);
	
	public List<UserProduct> findAllByUserId(int userId);
}