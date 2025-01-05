package com.gundamBoom.spring.buy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gundamBoom.spring.buy.domain.ProductList;

public interface UserOrderListRepository extends JpaRepository<ProductList, Integer> 
{
	public List<ProductList> findAllByProductId(int productId);
	
	public ProductList findByUserProductId(int userProductId);
	
	public List<ProductList> findAllByUserProductId(int userProductId);
}