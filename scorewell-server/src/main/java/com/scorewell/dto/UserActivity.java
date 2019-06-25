package com.scorewell.dto;

import com.scorewell.utils.StringUtils;

public class UserActivity {
	
	private String userName;
	private String emailId;
	private String phone;
	private String course;
	private String setName;
	private String fileName;
	private String filePath;
	private boolean evaluated;
	private long uploadDateTime;
	private long evaluateDateTime;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getSetName() {
		return setName;
	}
	public void setSetName(String setName) {
		this.setName = setName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath.substring(1);
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public boolean isEvaluated() {
		return evaluated;
	}
	public void setEvaluated(boolean evaluated) {
		this.evaluated = evaluated;
	}
	public String getUploadDateTime() {
		return StringUtils.formatDate(this.uploadDateTime, "dd-MM-yyyy");
	}
	public void setUploadDateTime(long uploadDateTime) {
		this.uploadDateTime = uploadDateTime;
	}
	public String getEvaluateDateTime() {
		return StringUtils.formatDate(this.evaluateDateTime, "dd-MM-yyyy");
	}
	public void setEvaluateDateTime(long evaluateDateTime) {
		this.evaluateDateTime = evaluateDateTime;
	}

}