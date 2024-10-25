package com.gundamBoom.spring.buy.apiKeyConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.siot.IamportRestClient.IamportClient;

@Configuration
public class ApiKey 
{
	String apiKey = "4834561586802810";
	String secretKey = ""; // seceret key를 그대로 깃허브 서버에 전송을 해서 secre key를 재발급 받아서 이전에 사용을 하던 seceret key는 삭제했습니다
	
	@Bean
	public IamportClient iamportClient()
	{
		return new IamportClient(apiKey, secretKey);
	}
}