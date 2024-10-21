package com.gundamBoom.spring.admin.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductView 
{
	private int productId; 
	
	private String name;
	
	private String menufacturer;
	
	private String price;
	
	private String imagePath;
	
	private String category;
	
	private String division;
}
