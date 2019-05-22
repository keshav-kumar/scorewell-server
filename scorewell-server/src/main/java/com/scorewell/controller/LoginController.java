package com.scorewell.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.scorewell.utils.HttpUtils;
import com.scorewell.dto.User;
import com.scorewell.service.UserService;
import com.scorewell.utils.JsonUtils;

@Controller
@RequestMapping("/auth/")
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

//	@Autowired
//	private UserService userService;
	
	@Autowired
	private Environment env;
	
	
	@RequestMapping(path="un",method={RequestMethod.POST})
	@ResponseBody
	public String loginByUserName(@RequestBody String credentials) {
		JsonObject jsonObject = (new JsonParser()).parse(credentials).getAsJsonObject();
		String response=HttpUtils.get(env.getProperty("api.server.url")+"auth/un?user="+jsonObject.get("user").getAsString()+"&pass="+jsonObject.get("pass").getAsString(), null);
		return response.toString();
	}
	
	@RequestMapping(path="ue",method={RequestMethod.POST,RequestMethod.GET}, consumes = {"text/plain", "application/*"})
	@ResponseBody
	public String loginByUserEmail(@RequestBody String credentials){
		JsonObject jsonObject = (new JsonParser()).parse(credentials).getAsJsonObject();
		String response=HttpUtils.get(env.getProperty("api.server.url")+"auth/ue?email="+jsonObject.get("user").getAsString()+"&pass="+jsonObject.get("pass").getAsString());
		return response.toString();
	}
	
	@RequestMapping(path="logout",method={RequestMethod.POST,RequestMethod.GET}, consumes = {"text/plain", "application/*"})
	@ResponseBody
	public String logout(@RequestParam String token){
		String response=HttpUtils.get(env.getProperty("api.server.url")+"auth/logout?token="+token);
		return response.toString();
	}

	@RequestMapping(path="vd",method={RequestMethod.POST,RequestMethod.GET}, consumes = {"text/plain", "application/*"})
	@ResponseBody
	public String validate(@RequestParam String token){
		String response=HttpUtils.get(env.getProperty("api.server.url")+"auth/vd?token="+token);
		return response.toString();
	}
	
	@RequestMapping(path="ud",method={RequestMethod.POST,RequestMethod.GET}, consumes = {"text/plain", "application/*"})
	@ResponseBody
	public String getUserDetail(@RequestParam String token){
		String response=HttpUtils.get(env.getProperty("api.server.url")+"auth/ud?token="+token);
		
		System.out.println("***************"+env.getProperty("api.server.url")+"auth/ud?token="+token+"***************");
		
		return response.toString();
	}
	
	@RequestMapping(path="fp",method={RequestMethod.POST,RequestMethod.GET}, consumes = {"text/plain", "application/*"})
	@ResponseBody
	public String forgotPassword(@RequestParam String email){
		String response=HttpUtils.get(env.getProperty("api.server.url")+"auth/fp?email="+email);
		return response.toString();
	}
	
}
