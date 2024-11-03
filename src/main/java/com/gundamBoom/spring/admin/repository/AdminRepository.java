package com.gundamBoom.spring.admin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gundamBoom.spring.admin.domain.Product;
import com.gundamBoom.spring.admin.dto.ProductView;

public interface AdminRepository extends JpaRepository<Product, Integer>
{
	// SELECT * FROM `product` ORDER 
	//public List<Product> findTop0ByOrderByIdDesc();
	public List<Product> findAllByOrderByIdDesc();
	
	public List<Product> findAllByCategoryOrderByIdDesc(String category);
}