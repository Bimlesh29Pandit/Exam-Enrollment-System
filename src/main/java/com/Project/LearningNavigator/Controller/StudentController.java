package com.Project.LearningNavigator.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Project.LearningNavigator.Model.Student;
import com.Project.LearningNavigator.Service.StudentService;
import com.Project.LearningNavigator.dto.StudentDto;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@GetMapping
	public ResponseEntity<List<StudentDto>> getAllStudent(){
		
		return studentService.getAllStudetn();
		
	}
	@GetMapping("/{registrationId}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable String registrationId){
		
		return studentService.getStudentById(registrationId);
		
	}
	@PostMapping
	public ResponseEntity<StudentDto> createStudent(@RequestBody Student student) {
		
		return studentService.createStudent(student);
		
	}
	@PutMapping
	public ResponseEntity<StudentDto> updateStudent(@RequestBody Student student){
		return studentService.updateStudent(student);
	}
	@DeleteMapping("/{registrationId}")
	public ResponseEntity<String> deleteStudent(@PathVariable String registrationId){
		
		return studentService.deleteStudent(registrationId);
	}
	@GetMapping("/subjectEnrollment")
	public StudentDto enrollSubject(@RequestParam String studentId, @RequestParam String subjectId){
		
		
		return studentService.enrollSubject(studentId,subjectId);
	}

}
