package com.scorewell.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	private static String PDF_SOURCE = "/src/main/webapp/WEB-INF/pdf/";
	private static String QUESTION = "question/";
	private static String ANSWER = "answer/";
	private static String REVIEW = "reviewed/";

	@Autowired
	private Environment env;

	public void saveUploadedPdfFiles(List<MultipartFile> files, HttpServletRequest request, String uploadType)
			throws IOException {

		for (MultipartFile file : files) {

			if (file.isEmpty()) {
				continue;
			}
			String basePathOfClass = new File(".").getAbsolutePath();
			byte[] bytes = file.getBytes();

			String subDir_fileName = "";
			if (uploadType.equals("Q"))
				subDir_fileName = QUESTION + file.getOriginalFilename();
			else if (uploadType.equals("A"))
				subDir_fileName = ANSWER + request.getParameter("phone") + "_" + request.getParameter("email") + "_"
						+ request.getParameter("fileName");
			else if (uploadType.equals("R"))
				subDir_fileName = REVIEW + request.getParameter("phone") + "_" + request.getParameter("email") + "_"
						+ request.getParameter("fileName");
			
			System.out.println("Sub DIR : "+basePathOfClass + PDF_SOURCE + subDir_fileName);

			Path path = Paths.get(basePathOfClass + PDF_SOURCE + subDir_fileName);
			Files.write(path, bytes);

		}

	}
}
