package com.gundamBoom.spring.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManager 
{
	// 업로드 경로를 지정하기 위한 전역 변수 선언
	public static final String FILE_UPLOAD_PATH = "D:\\ahn_sung_min\\spring_project\\upload";
	
	// 파일 저장
	public static String saveFile(MultipartFile file)
	{
		if(file == null) // 전달 받은 파일이 유효하지 않으면 참
		{
			return null;
		}
		
		String directoryName = "/" + "product" + "_" + System.currentTimeMillis(); // 디렉터리의 이름을 /_(1/1000)을 기준으로 한다
		
		// 디렉터리의 경로를 설정합니다
		String directoryPath = FILE_UPLOAD_PATH + directoryName;
		
		// 파일 객체를 생성합니다.
		File directory = new File(directoryPath);
		
		if(!directory.mkdir()) // 디렉터리를 생성한 뒤 반환된 값이 유효하지 않으면 참
		{
			return null;
		}
		
		String filePath = directoryPath + "/" + file.getOriginalFilename(); //파일 경로를 (디렉터리 경로 + 파일 이름)으로 합니다
		
		try
		{
			byte[] bytes = file.getBytes(); // 0과 1로 이루어진 파일의 정보를 얻어옵니다
			Path path = Paths.get(filePath); // Paths.get(filePath)를 통해서 파일의 경로를 저장을 하기 위한 변수에 저장을합니다
			Files.write(path, bytes);			
		}
		catch(IOException e)
		{
			// 파일 저장을 실패하면 null을 반환
			return null;
		}
		
		return "/images" + directoryName + "/" + file.getOriginalFilename(); // /(upload + /directoryName)/fileName을 반환합니다
	}
}