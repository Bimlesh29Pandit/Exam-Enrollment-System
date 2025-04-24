package com.Project.LearningNavigator.dto;

public class ExamDto {
	
	private String ExamId;
	private SubjectDto subject;
	public String getExamId() {
		return ExamId;
	}
	public void setExamId(String examId) {
		ExamId = examId;
	}
	public SubjectDto getSubject() {
		return subject;
	}
	public void setSubject(SubjectDto subject) {
		this.subject = subject;
	}
	public ExamDto(String examId, SubjectDto subject) {
		super();
		ExamId = examId;
		this.subject = subject;
	}
	public ExamDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ExamDto [ExamId=" + ExamId + ", subject=" + subject + "]";
	}

	
}
