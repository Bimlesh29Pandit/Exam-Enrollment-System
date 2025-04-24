package com.Project.LearningNavigator.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Exam {
	
	@Id
	private String examId;
	@OneToOne
	private Subject subject;
	@ManyToMany(mappedBy = "exams")
	private List<Student> student;
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public Exam(String examId, Subject subject, List<Student> student) {
		super();
		this.examId = examId;
		this.subject = subject;
		this.student = student;
	}
	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", subject=" + subject + ", student=" + student + "]";
	}
	
	
	
}
