package com.gundamBoom.spring.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gundamBoom.spring.payment.domain.UserProductList;

public interface ProductListRepository extends JpaRepository<UserProductList, Integer> 
{

}
