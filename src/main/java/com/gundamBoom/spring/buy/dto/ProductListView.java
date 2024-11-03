package com.gundamBoom.spring.buy.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductListView 
{
	private int userProductId;
	private int productId;
	private int count;
}
