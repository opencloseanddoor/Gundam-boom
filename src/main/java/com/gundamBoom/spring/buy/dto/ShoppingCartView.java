package com.gundamBoom.spring.buy.dto;

import com.gundamBoom.spring.admin.domain.Product;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ShoppingCartView 
{
	private int id;
	private int productId;
	private int userId;
	private String name;	
	private Product product;
	private String imagePath;
	private int count;
}
