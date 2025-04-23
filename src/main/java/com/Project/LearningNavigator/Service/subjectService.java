package com.Project.LearningNavigator.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Project.LearningNavigator.Exception.ResourceNotFoundException;
import com.Project.LearningNavigator.Model.Subject;
import com.Project.LearningNavigator.Repo.SubjectRepository;

@Service
public class subjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;

	public ResponseEntity<List<Subject>> getAllSubject() {
		
		return new ResponseEntity<>(subjectRepository.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<String> deleteSubject(String subjectId) {
		// TODO Auto-generated method stub
		subjectRepository.deleteById(subjectId);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	 public ResponseEntity<Subject> create(Subject subject) {
	        return new ResponseEntity<Subject>( subjectRepository.save(subject),HttpStatus.CREATED);
	    }

	public ResponseEntity<Subject> getSubjectById(String subjectId) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Subject>(subjectRepository.findById(subjectId).orElseThrow(()-> new ResourceNotFoundException("Subject Not Found")),HttpStatus.OK);
	}

	public ResponseEntity<Subject> updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Subject>(subjectRepository.save(subject),HttpStatus.OK);
	}
	 
	 

}
