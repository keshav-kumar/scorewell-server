package com.scorewell.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.scorewell.service.DaoService;
import com.scorewell.service.ScorewellService;
import com.scorewell.service.UserService;
import com.scorewell.db.MongoDBManager;
import com.scorewell.dto.QuestionSet;
import com.scorewell.dto.UserActivity;


@Controller
public class ScoreWellController {

	private final Logger logger = LoggerFactory.getLogger(ScoreWellController.class);
	
	@Autowired private Environment env;
	@Autowired private ScorewellService scorewellService;
	@Autowired private DaoService daoService;

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView homePageController(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("Welcome Scorewell Home page.");
		model.addAttribute("isDataAvail", "YES");
		
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = { "/about" })
	public ModelAndView aboutPageController(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("Welcome to About Section");
		model.addAttribute("isDataAvail", "YES");
		
		return new ModelAndView("about-us");
	}
	
	@RequestMapping(value = { "/course-info" })
	public ModelAndView iasProgramPageController(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("Welcome to About Section");
		model.addAttribute("isDataAvail", "YES");
		
		return new ModelAndView("course-info");
	}
	
	@RequestMapping(value = { "/career" })
	public ModelAndView careerPageController(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("Welcome to About Section");
		model.addAttribute("isDataAvail", "YES");
		
		return new ModelAndView("career");
	}
	
	@RequestMapping(value = { "/daily-questions" })
	public ModelAndView iasDailyQuestionPageController(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("Welcome to About Section");

		List<QuestionSet> questionSets = daoService.getQuestionSet(request);
		model.addAttribute("questionSets", questionSets);
		
		return new ModelAndView("daily-questions");
	}
	
	@RequestMapping(value = { "/question-set" })
	public ModelAndView questionSetPageController(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println(request.getParameter("set-name"));
		
		QuestionSet questionSet = scorewellService.getQuestionSetByName(request.getParameter("set-name"));
		model.addAttribute("questionSet", questionSet);
		model.addAttribute("fileBasePath", env.getProperty("resources.dir")+"question/");
		
		return new ModelAndView("question-set");
	}
	
	@RequestMapping(value = { "/courses" })
	public ModelAndView coursePageController(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("Welcome to News Section");
		model.addAttribute("isDataAvail", "YES");
		
		return new ModelAndView("courses");
	}
	
	@RequestMapping(value = { "/contact" })
	public ModelAndView contactPageController(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("Welcome to CONTACT Section");
		
		return new ModelAndView("contact");
	}
	
	@RequestMapping(value = { "/resource" })
	public ModelAndView resourcePageController(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("Welcome to RESOURCE Section");
		
		return new ModelAndView("resource");
	}
	
	@RequestMapping(value = { "/ias-courses" })
	public ModelAndView iasCoursePageController(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("Welcome to IAS Question Section");
		
		return new ModelAndView("ias-daily-papers");
	}
	
	@RequestMapping(value = { "/set-list" })
	public ModelAndView setListPageController(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		List<UserActivity> activitySetList = daoService.getUserActivity(request);
		model.addAttribute("sets", activitySetList);
		
		return new ModelAndView("setList");
	}
	
	@RequestMapping(value = "/reviewcomment", method = { RequestMethod.GET }, consumes = { "text/plain", "application/*" })
	public ModelAndView reviewWithCommentController(@RequestParam String name, @RequestParam String phone, @RequestParam String email, @RequestParam String setName, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		UserActivity activity = daoService.getUserActivity(name, phone, email, setName);
		QuestionSet questionSet = daoService.getQuestionSetByName(setName);
		model.addAttribute("activityDetails", activity);
		model.addAttribute("questionFile", questionSet);
		
		System.out.println("User Name : "+name);
		
		return new ModelAndView("reviewWithComment");
	}
	
	@RequestMapping(value = { "/login-page" })
	public ModelAndView loginPageController(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("Welcome to Login Section");
		model.addAttribute("isDataAvail", "YES");
		
		return new ModelAndView("login-page");
	}
	
	
}
