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
import com.Project.LearningNavigator.dto.SubjectDto;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
	
	@Autowired
	private subjectService subjectService;
	
	@GetMapping
	public ResponseEntity<List<SubjectDto>> getAllSubject(){
		
		return subjectService.getAllSubject();
	}
	@GetMapping("/{subjectId}")
	public ResponseEntity<SubjectDto> getSubjectById(@PathVariable String subjectId){
		return subjectService.getSubjectById(subjectId);
	}
	
	@DeleteMapping("/{subjectId}")
	public ResponseEntity<String> deleteSubject(@PathVariable String subjectId){
		return subjectService.deleteSubject(subjectId);
	}
	@PostMapping
	public ResponseEntity<SubjectDto> create(@RequestBody Subject subject){
		
		return subjectService.create(subject);
	}
	@PutMapping
	public ResponseEntity<SubjectDto> updateSubject(@RequestBody Subject subject){
		return subjectService.updateSubject(subject);
	}

}
