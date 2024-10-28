package com.gundamBoom.spring.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gundamBoom.spring.user.domain.User;

@Mapper
public interface UserRepository 
{
	public int insertUser
	(
		@Param("loginId") String loginId,
		@Param("password") String password,
		@Param("name") String name,
		@Param("address") String address,
		@Param("phoneNumber") String phoneNumber
	);
	
	public User selectUser
	(
		@Param("loginId") String loginId,
		@Param("password") String password
	);
	
	public int selectCountByLoginId
	(
		@Param("loginId") String loginId
	);
}