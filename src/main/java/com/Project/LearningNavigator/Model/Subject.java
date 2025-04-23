package com.Project.LearningNavigator.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Subject {
	
	@Id
    private String subjectId;
	private String subjectName;
	@ManyToMany
	private List<Student> Students;
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
	public List<Student> getStudents() {
		return Students;
	}
	public void setStudents(List<Student> students) {
		Students = students;
	}
	public Subject(String subjectId, String subjectName, List<Student> students) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		Students = students;
	}
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", Students=" + Students + "]";
	}
	
	
}
