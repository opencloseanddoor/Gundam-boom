package com.gundamBoom.spring.payment.apiKeyConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.siot.IamportRestClient.IamportClient;

@Configuration
public class ApiKey 
{
	String apiKey = "4834561586802810";
	String secretKey = "WHHsBtobBEFHLbV41tLEVyH2HywyTjlSV577Oy7NYYcfkYfjoNSvtLPxzkZ0IiDeQDI72jPFF1QiAlDN";
	
	@Bean
	public IamportClient iamportClient()
	{
		return new IamportClient(apiKey, secretKey);
	}
}