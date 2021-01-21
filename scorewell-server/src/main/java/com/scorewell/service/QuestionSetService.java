package com.scorewell.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.scorewell.service.DaoService;
import com.scorewell.utils.JsonUtils;
import com.scorewell.utils.StringUtils;
import com.google.gson.JsonObject;
import com.scorewell.dto.Question;
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
//		questionSet.setSetName(request.getParameter("setName"));
		questionSet.setSubjectName(request.getParameter("subject"));

		questionSet.setReleaseDate(StringUtils.strToDate(request.getParameter("publishDate"), "dd-MM-yyyy").getTime());
		
		String setName = request.getParameter("subject") + "_Test_" + StringUtils.generateSetNumber(daoService.getLatestQuestionSetName(request.getParameter("course"), request.getParameter("subject")));
		questionSet.setSetName(setName);
		
		Question question1 = new Question();
		question1.setQuestion(request.getParameter("que1"));
		question1.setQuestionId(request.getParameter("course")+"_"+setName+"-Q1");
		
		Question question2 = new Question();
		question2.setQuestion(request.getParameter("que2"));
		question2.setQuestionId(request.getParameter("course")+"_"+setName+"-Q2");
		
		Question question3 = new Question();
		question3.setQuestion(request.getParameter("que3"));
		question3.setQuestionId(request.getParameter("course")+"_"+setName+"-Q3");
		
		List<Question> questions = new ArrayList<Question>();
		questions.add(question1);
		questions.add(question2);
		questions.add(question3);
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
	
	public JsonObject deleteAdditionInsured(String setName) {
//		daoService.deleteQuestionSet(setName);
		return JsonUtils.createSuccessResponse("deleted " + setName);
	}
	
	
	
	public void updateUserActivity(HttpServletRequest request) {
		
		daoService.updateUserActivity(request);
		
	}

}
