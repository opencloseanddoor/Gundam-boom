package com.gundamBoom.spring.payment.domain;

import java.time.LocalDateTime;

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

@Builder(toBuilder=true) //builder메소드와 toBuilder메소드를 사용할 수 있도록 합니다
@AllArgsConstructor // 모든 필드를 매개변수로 전달을 받는 생성자를 자동으로 생성합니다
@NoArgsConstructor // 매개변수를 전달 받지 않는 생성자를 자동으로 생성합니다
@Table(name="userProduct") //내가 열어놓은 DB Server의 스키마와 매칭을 시킵니다
@Getter // getter메소드를 자동으로 생성합니다
@Entity // 해당 클래스 즉 Order클래스를 Entity클래스로 정의합니다
public class UserProduct 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="userId")
	private int userId;
	private String status;
	private String name;
	@Column(name="phoneNumber")
	private String phoneNumber;
	private String address;
	@CreationTimestamp
	@Column(name="createdAt")
	private LocalDateTime createdAt;
	@UpdateTimestamp
	@Column(name="updatedAt")
	private LocalDateTime updatedAt;
}
