package com.bluesquare.app.service;

import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;


@Service
public class FileService {
	
	//업로드 파일 저장
	public static String uploadFile(String uploadPath, String originalFileName, 
							byte[] fileData) throws Exception{
		
		UUID uuid = UUID.randomUUID();
		
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
		
		String savedFileName = uuid.toString() + extension;
		
		String fileUploadFullUrl = uploadPath + "/" + savedFileName;
		
		FileOutputStream fos = new FileOutputStream(fileUploadFullUrl);
		
		fos.write(fileData);
		fos.close();
		
		return savedFileName;
	}
}

