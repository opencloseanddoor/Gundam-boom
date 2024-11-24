package com.gundamBoom.spring.buy.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ShoppingCartView 
{
	private int id;
	private int productId;
	private int userId;
	private int count;
}
