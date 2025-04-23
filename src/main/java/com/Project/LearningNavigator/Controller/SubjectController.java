package com.Project.LearningNavigator.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.LearningNavigator.Model.Subject;
import com.Project.LearningNavigator.Service.subjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
	
	@Autowired
	private subjectService subjectService;
	
	@GetMapping
	public ResponseEntity<List<Subject>> getAllSubject(){
		return subjectService.getAllSubject();
	}
	@GetMapping("/{subejctId}")
	public ResponseEntity<Subject> getSubjectById(@PathVariable String subjectId){
		return subjectService.getSubjectById(subjectId);
	}
	
	@DeleteMapping("/{subjectId}")
	public ResponseEntity<String> deleteSubject(@PathVariable String subjectId){
		return subjectService.deleteSubject(subjectId);
	}
	@PostMapping
	public ResponseEntity<Subject> create(@RequestBody Subject subject){
		
		return subjectService.create(subject);
	}
	@PutMapping
	public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject){
		return subjectService.updateSubject(subject);
	}

}
