package com.scorewell.dto;

import java.util.List;

import com.scorewell.utils.StringUtils;

public class QuestionSet extends BaseDBObject {

	private String course;
	private String setName;
	private String subjectName;
	private String pdfFileName;
	private List<Question> questions;
	private long releaseDate;
	
	public String getSetName() {
		return setName;
	}
	public void setSetName(String setName) {
		this.setName = setName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getPdfFileName() {
		return pdfFileName;
	}
	public void setPdfFileName(String pdfFileName) {
		this.pdfFileName = pdfFileName;
	}
//	public List<String> getQuestions() {
//		return questions;
//	}
//	public void setQuestions(List<String> questions) {
//		this.questions = questions;
//	}
	public String getReleaseDate() {
		return StringUtils.formatDate(this.releaseDate, "dd-MM-yyyy");
	}
	public void setReleaseDate(long releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
}
