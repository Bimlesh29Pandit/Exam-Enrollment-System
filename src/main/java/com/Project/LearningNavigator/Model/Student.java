package com.Project.LearningNavigator.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
	private String registrationId;
	private String studentName;
	@ManyToMany
	private List<Subject> subjects;
	@ManyToMany
	private List<Exam> exams;
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public List<Exam> getExams() {
		return exams;
	}
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	public Student(String registrationId, String studentName, List<Subject> subjects, List<Exam> exams) {
		super();
		this.registrationId = registrationId;
		this.studentName = studentName;
		this.subjects = subjects;
		this.exams = exams;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [registrationId=" + registrationId + ", studentName=" + studentName + ", subjects=" + subjects
				+ ", exams=" + exams + "]";
	}
	

}
