package com.scorewell.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.scorewell.service.DaoService;
import com.scorewell.utils.StringUtils;
import com.scorewell.dto.QuestionSet;
import com.scorewell.dto.UserActivity;

@Service
public class QuestionSetService {

	private static Logger logger = LoggerFactory.getLogger(QuestionSetService.class);

	@Autowired
	private DaoService daoService;

	public String createQuestionSet(HttpServletRequest request, String pdfFileName) {

		QuestionSet questionSet = new QuestionSet();

		questionSet.setCourse(request.getParameter("course"));
		questionSet.setSetName(request.getParameter("setName"));
		questionSet.setSubjectName(request.getParameter("subject"));

		questionSet.setReleaseDate(StringUtils.strToDate(request.getParameter("publishDate"), "dd-MM-yyyy").getTime());

		List<String> questions = new ArrayList<String>();
		questions.add(request.getParameter("que1"));
		questions.add(request.getParameter("que2"));
		questions.add(request.getParameter("que3"));
		questionSet.setQuestions(questions);
		questionSet.setPdfFileName(pdfFileName);

		questionSet.setCreateTime(System.currentTimeMillis());
		questionSet.setUpdateTime(System.currentTimeMillis());
		questionSet.setDeleted(false);

		return daoService.createQuestionSet(questionSet);
	}
	
	public String saveUserActivity(HttpServletRequest request, String fileDir) {
		
		UserActivity userActivity = new UserActivity();
		userActivity.setUserName(request.getParameter("name"));
		userActivity.setEmailId(request.getParameter("email"));
		userActivity.setPhone(request.getParameter("phone"));
		userActivity.setCourse(request.getParameter("course"));
		userActivity.setSetName(request.getParameter("setName"));
		userActivity.setFileName(request.getParameter("fileName"));
		userActivity.setFilePath(fileDir);
		userActivity.setEvaluated(false);
		userActivity.setUploadDateTime(System.currentTimeMillis());
		userActivity.setEvaluateDateTime(System.currentTimeMillis());
		
		String userActivityId = daoService.saveUserActivity(userActivity);
		
		return userActivityId;
	}
	
	public void updateUserActivity(HttpServletRequest request) {
		
		daoService.updateUserActivity(request);
		
	}

}
