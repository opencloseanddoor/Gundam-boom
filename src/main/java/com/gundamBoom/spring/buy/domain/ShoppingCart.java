package com.gundamBoom.spring.buy.domain;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Table(name="shoppingCart")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class ShoppingCart 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="productId")
	private int productId;
	
	private int count;
	
	@CreationTimestamp
	@Column(name="createdAt")
	private LocalDate createdAt;
}
