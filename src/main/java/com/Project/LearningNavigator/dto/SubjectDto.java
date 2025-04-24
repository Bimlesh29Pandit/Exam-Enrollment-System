package com.Project.LearningNavigator.dto;

public class SubjectDto {
	
	private String subjectId;
	private String subjectName;
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public SubjectDto(String subjectId, String subjectName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}
	public SubjectDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SubjectDto [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}
	
	

}
