package com.gundamBoom.spring.buy.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserProductView //관리자 전용 DTO
{
	private int  userId;
	private String status;
	private String name;
	private String phoneNumber;
	private String address;
}