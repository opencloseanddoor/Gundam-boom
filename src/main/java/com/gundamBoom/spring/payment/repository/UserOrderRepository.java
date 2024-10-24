package com.gundamBoom.spring.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gundamBoom.spring.payment.domain.UserProduct;

public interface UserOrderRepository extends JpaRepository<UserProduct, Integer> 
{	

}