package com.gundamBoom.spring.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
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
		MultipartFile imageFile,
		String category,
		String division
	)
	{
		String urlPath = FileManager.saveFile(imageFile);
		
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
		
		List<ProductView> productViewList = new ArrayList<>();
		
		for(Product product : productList)
		{
			ProductView cardView = ProductView.builder()
					.productId(product.getId())
					.name(product.getName())
					.menufacturer(product.getMenufacturer())
					.price(product.getPrice())
					.imagePath(product.getImagePath())
					.category(product.getCategory())
					.division(product.getDivision())
					.build();
			
			productViewList.add(cardView);
		}
		
		return productViewList;
	}
	
	public List<ProductView> getProductListByCategory(String category)
	{		
		List<Product> productList = adminRepository.findAllByCategoryOrderByIdDesc(category);
		
		List<ProductView> productViewList = new ArrayList<>();
		
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
			
			productViewList.add(cardView);
		}
		
		return productViewList;
	}
	
	public boolean delete(int productId)
	{
		Optional<Product> optionalProduct = adminRepository.findById(productId);
		Product product = optionalProduct.orElse(null);
		
		if(product != null)
		{
			FileManager.removeFile(product.getImagePath());
			adminRepository.delete(product);
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public Product updateProduct
	(
			String name,
			String menufacturer,
			String price, 
			MultipartFile imageFile,
			String category,
			String division
	)
	{
		String urlPath = FileManager.saveFile(imageFile);
		
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
}