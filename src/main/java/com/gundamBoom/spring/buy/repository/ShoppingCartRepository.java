package com.gundamBoom.spring.buy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gundamBoom.spring.buy.domain.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> 
{
	public List<ShoppingCart> findAllByUserIdOrderByIdDesc(int userId);
}
