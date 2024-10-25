package com.gundamBoom.spring.buy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gundamBoom.spring.buy.domain.UserProductList;

public interface UserOrderListRepository extends JpaRepository<UserProductList, Integer> 
{
	
}
