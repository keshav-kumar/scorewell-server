package com.scorewell.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.scorewell.dto.QuestionSet;
import com.scorewell.dto.UserActivity;
import com.scorewell.service.DaoService;
import com.scorewell.service.UserService;

@Controller
public class AdminController {


	private final Logger logger = LoggerFactory.getLogger(RestUploadController.class);
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//    private Environment env;
	
	@Autowired private DaoService daoService;

	@RequestMapping(value = { "/subscribers" })
	public ModelAndView getSubscribersPageController(HttpServletRequest request, HttpServletResponse response,
			Model model) {
		List<String> subscribers = userService.getAllSubscribers();
		model.addAttribute("subscriber_email", subscribers);

		System.out.println(subscribers);

		return new ModelAndView("subscribers");
	}
	
	@RequestMapping(value = { "/admin" })
	public ModelAndView adminPageController(HttpServletRequest request, HttpServletResponse response,
			Model model) {

		List<QuestionSet> questionSets = daoService.getQuestionSet(request);
		model.addAttribute("questionSets", questionSets);
		
		return new ModelAndView("admin-questions");
	}

	@RequestMapping(value = { "/create-question" })
	public ModelAndView createQuestionPageController(HttpServletRequest request, HttpServletResponse response,
			Model model) {

		return new ModelAndView("create_question");
	}
	
	@RequestMapping(value = { "/admin-answer-list" })
	public ModelAndView answerSheetPageController(HttpServletRequest request, HttpServletResponse response,
			Model model) {

		List<UserActivity> listAnswerSheet = daoService.getUserActivityAdmin(request);
		model.addAttribute("answerSheet", listAnswerSheet);
		
		return new ModelAndView("admin-answer-page");
	}
	
	@RequestMapping(value = { "/upload-review" })
	public ModelAndView uploadReviewPageController(HttpServletRequest request, HttpServletResponse response,
			Model model) {

//		List<UserActivity> listAnswerSheet = daoService.getUserActivityAdmin(request);
		
		UserActivity listAnswerSheet = new UserActivity();
		listAnswerSheet.setSetName(request.getParameter("setName"));
		listAnswerSheet.setPhone(request.getParameter("phone"));
		listAnswerSheet.setEmailId(request.getParameter("emailId"));
		listAnswerSheet.setUserName(request.getParameter("userName"));
		listAnswerSheet.setCourse(request.getParameter("courseName"));
		listAnswerSheet.setSubjectName(request.getParameter("subjectName"));
		listAnswerSheet.setFileName(request.getParameter("fileName"));
		
		model.addAttribute("userAnswerSheet", listAnswerSheet);
		
		return new ModelAndView("upload-review-page");
	}

}
