package com.gundamBoom.spring.admin.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductView 
{
	private String name;
	
	private String menufacturer;
	
	private String price;
	
	private String imagePath;
	
	private String category;
	
	private String division;
}
