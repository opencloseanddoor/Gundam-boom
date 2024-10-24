package com.gundamBoom.spring.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gundamBoom.spring.payment.domain.UserProduct;

public interface ProductRepository extends JpaRepository<UserProduct, Integer> 
{	

}