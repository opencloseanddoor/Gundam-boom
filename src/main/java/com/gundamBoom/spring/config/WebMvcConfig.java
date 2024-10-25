package com.gundamBoom.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gundamBoom.spring.common.FileManager;

//아래의 코드는 클라이언드가 서버에 저장이 된 사진에 접근을 할 수 있도록 하기위한 코드입니다
@Configuration
public class WebMvcConfig implements WebMvcConfigurer 
{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/images/**")
		.addResourceLocations("file:///" + FileManager.FILE_UPLOAD_PATH + "/");	//MAC또는 리눅스에서는 //(/이 2개만 필요) 윈도우에서는 ///(/이 3개 필요)하다	
	}
}