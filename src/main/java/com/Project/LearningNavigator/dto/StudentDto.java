package com.Project.LearningNavigator.dto;

import java.util.List;

public class StudentDto {
	
	private String registrationId;
	private String StudentName;
	private List<SubjectDto> enrolledSubject;
	private List<ExamDto> enrolledExam;
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public List<SubjectDto> getEnrolledSubject() {
		return enrolledSubject;
	}
	public void setEnrolledSubject(List<SubjectDto> enrolledSubject) {
		this.enrolledSubject = enrolledSubject;
	}
	public List<ExamDto> getEnrolledExam() {
		return enrolledExam;
	}
	public void setEnrolledExam(List<ExamDto> enrolledExam) {
		this.enrolledExam = enrolledExam;
	}
	public StudentDto(String registrationId, String studentName, List<SubjectDto> enrolledSubject,
			List<ExamDto> enrolledExam) {
		super();
		this.registrationId = registrationId;
		StudentName = studentName;
		this.enrolledSubject = enrolledSubject;
		this.enrolledExam = enrolledExam;
	}
	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StudentDto [registrationId=" + registrationId + ", StudentName=" + StudentName + ", enrolledSubject="
				+ enrolledSubject + ", enrolledExam=" + enrolledExam + "]";
	}
	
	

}
