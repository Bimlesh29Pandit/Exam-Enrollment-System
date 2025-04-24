package com.Project.LearningNavigator.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Project.LearningNavigator.Exception.ResourceNotFoundException;
import com.Project.LearningNavigator.Model.Subject;
import com.Project.LearningNavigator.Repo.SubjectRepository;
import com.Project.LearningNavigator.dto.SubjectDto;

@Service
public class subjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;

	public ResponseEntity<List<SubjectDto>> getAllSubject() {
		
		List<SubjectDto> subejctDtos = subjectRepository.findAll().stream()
				.map(sub-> new SubjectDto(sub.getSubjectId(),sub.getSubjectName()))
				.collect(Collectors.toList());
		
		
		return new ResponseEntity<>(subejctDtos, HttpStatus.OK);
	}

	public ResponseEntity<String> deleteSubject(String subjectId) {
		// TODO Auto-generated method stub
		subjectRepository.deleteById(subjectId);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	 public ResponseEntity<SubjectDto> create(Subject subject) {
		 Subject subjects = subjectRepository.save(subject);
		 SubjectDto subjectDto = new SubjectDto(subject.getSubjectId(),subject.getSubjectName());
		 
	        return new ResponseEntity<>( subjectDto,HttpStatus.CREATED);
	    }

	public ResponseEntity<SubjectDto> getSubjectById(String subjectId) {
		// TODO Auto-generated method stub
		Subject subject =  subjectRepository.findById(subjectId).orElseThrow(()-> new ResourceNotFoundException("Subject Not Found with Id : "+subjectId));
		
		SubjectDto subjectDto = new SubjectDto(subject.getSubjectId(),subject.getSubjectName());
		
		return new ResponseEntity<SubjectDto>(subjectDto,HttpStatus.OK);
	}

	public ResponseEntity<SubjectDto> updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		 Subject subjects = subjectRepository.save(subject);
		 SubjectDto subjectDto = new SubjectDto(subject.getSubjectId(),subject.getSubjectName());
		 
		return new ResponseEntity<>(subjectDto,HttpStatus.OK);
	}
	 
	 

}
