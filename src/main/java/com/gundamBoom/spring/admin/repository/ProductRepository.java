package com.gundamBoom.spring.admin.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import com.gundamBoom.spring.admin.domain.Product;

@Mapper
public interface ProductRepository 
{
	public int productUpdate
	(	
		@Param("productId") int productId,
		@Param("name") String name,
		@Param("menufacturer") String menufacturer,
		@Param("price") String price,
		@Param("imagePath") MultipartFile imagePath,
		@Param("category") String category,
		@Param("division") String division
	);
	
	 Optional<Product> findById(int productId);
}