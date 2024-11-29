package com.gundamBoom.spring.buy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gundamBoom.spring.buy.domain.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> 
{
	public List<ShoppingCart> findAllByUserIdOrderByIdDesc(int userId);
	
	public List<ShoppingCart> findAllByUserId(int userId); // userId로 모든 장바구니 목록을 얻어오는 jpa쿼리를 작성
} 