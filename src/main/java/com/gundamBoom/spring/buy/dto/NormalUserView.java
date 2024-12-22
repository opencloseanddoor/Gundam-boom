package com.gundamBoom.spring.buy.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NormalUserView
{
	private int productId;
	private String name;
	private String productName;
	private String imagePath;
	private String status;
	private int count;
}