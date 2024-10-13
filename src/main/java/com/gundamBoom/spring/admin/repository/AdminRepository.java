package com.gundamBoom.spring.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gundamBoom.spring.admin.domain.Product;

public interface AdminRepository extends JpaRepository<Product, Integer>
{
	
}
