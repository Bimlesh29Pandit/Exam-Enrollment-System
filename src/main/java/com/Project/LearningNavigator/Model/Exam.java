package com.Project.LearningNavigator.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Exam {
	
	@Id
	private String examId;
	@ManyToOne
	private Subject subejct;
	@ManyToMany
	private List<Student> student;
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	public Subject getSubejct() {
		return subejct;
	}
	public void setSubejct(Subject subejct) {
		this.subejct = subejct;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public Exam(String examId, Subject subejct, List<Student> student) {
		super();
		this.examId = examId;
		this.subejct = subejct;
		this.student = student;
	}
	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", subejct=" + subejct + ", student=" + student + "]";
	}
	
	
}
