package com.scorewell.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	private static String PDF_SOURCE = "/src/main/webapp/WEB-INF/pdf/";
	
	@Autowired
    private Environment env;

	public void saveUploadedPdfFiles(List<MultipartFile> files, String fileSubName, String fileDir) throws IOException {

		
		for (MultipartFile file : files) {

			if (file.isEmpty()) {
				continue;
			}
			String basePathOfClass = new File(".").getAbsolutePath();
			byte[] bytes = file.getBytes();
			Path path = Paths.get(basePathOfClass+PDF_SOURCE+fileDir + fileSubName + file.getOriginalFilename());
			Files.write(path, bytes);

		}

	}
}
