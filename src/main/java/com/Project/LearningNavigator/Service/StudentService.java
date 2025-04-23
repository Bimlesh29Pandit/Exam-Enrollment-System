package com.Project.LearningNavigator.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Project.LearningNavigator.Exception.ResourceNotFoundException;
import com.Project.LearningNavigator.Model.Student;
import com.Project.LearningNavigator.Model.Subject;
import com.Project.LearningNavigator.Repo.StudentRepository;
import com.Project.LearningNavigator.Repo.SubjectRepository;


@Service
public class StudentService {
	@Autowired
    private StudentRepository studentRepo;
	@Autowired
    private SubjectRepository subjectRepo;

    public Student enrollSubject(String studentId, String subjectId) {
        Student student = studentRepo.findById(studentId)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Subject subject = subjectRepo.findById(subjectId)
            .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));

        student.getSubjects().add(subject);
        return studentRepo.save(student);
    }

	public ResponseEntity<List<Student>> getAllStudetn() {
		// TODO Auto-generated method stub
		return new ResponseEntity(studentRepo.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<Student> createStudent(Student student) {
		
		return new ResponseEntity<Student>(studentRepo.save(student),HttpStatus.CREATED);
	}

	public ResponseEntity<Student> updateStudent(Student student) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Student>(studentRepo.save(student),HttpStatus.CREATED);
	}

	public ResponseEntity<String> deleteStudent(String registrationId) {
		
		studentRepo.deleteById(registrationId);
		// TODO Auto-generated method stub
		return new ResponseEntity<>("Deleted",HttpStatus.OK);
	}

	public ResponseEntity<Student> getStudentById(String registrationId) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(studentRepo.findById(registrationId).orElseThrow(()-> new ResourceNotFoundException("Student Not found")),HttpStatus.OK);
	}

	

}

