package com.gundamBoom.spring.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gundamBoom.spring.admin.domain.Product;
import com.gundamBoom.spring.admin.dto.ProductView;
import com.gundamBoom.spring.admin.repository.AdminRepository;
import com.gundamBoom.spring.common.FileManager;

@Service
public class AdminService 
{
	private AdminRepository adminRepository;
	
	public AdminService
	(
		AdminRepository adminRepository
	)
	{
		this.adminRepository = adminRepository;
	}
	
	public Product insertProduct
	(
		String name,
		String menufacturer,
		String price,
		MultipartFile imagePath,
		String category,
		String division
	)
	{
		String urlPath = FileManager.savaFile(imagePath);
		
		Product product = Product
				.builder()
				.name(name)
				.menufacturer(menufacturer)
				.price(price)
				.imagePath(urlPath)
				.category(category)
				.division(division)
				.build();
		
		Product result = adminRepository.save(product);
		
		return result;
	}
	
	public List<ProductView> getProductList()
	{
		List<Product> productList = adminRepository.findAllByOrderByIdDesc();
		
		List<ProductView> cardViewList = new ArrayList<>();
		
		for(Product product : productList)
		{
			ProductView cardView = ProductView.builder()
					.name(product.getName())
					.menufacturer(product.getMenufacturer())
					.price(product.getPrice())
					.imagePath(product.getImagePath())
					.category(product.getCategory())
					.division(product.getDivision())
					.build();
			
			System.out.println("사진 이미지 : " + product.getImagePath());
			
			cardViewList.add(cardView);
		}
		
		return cardViewList;
	}
}