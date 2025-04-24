package com.Project.LearningNavigator.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Project.LearningNavigator.Exception.ResourceNotFoundException;
import com.Project.LearningNavigator.Model.Exam;
import com.Project.LearningNavigator.Model.Student;
import com.Project.LearningNavigator.Model.Subject;
import com.Project.LearningNavigator.Repo.StudentRepository;
import com.Project.LearningNavigator.Repo.SubjectRepository;
import com.Project.LearningNavigator.dto.ExamDto;
import com.Project.LearningNavigator.dto.StudentDto;
import com.Project.LearningNavigator.dto.SubjectDto;


@Service
public class StudentService {
	@Autowired
    private StudentRepository studentRepo;
	@Autowired
    private SubjectRepository subjectRepo;

    public StudentDto enrollSubject(String studentId, String subjectId) {
        Student student = studentRepo.findById(studentId)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Subject subject = subjectRepo.findById(subjectId)
            .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));

        student.getSubjects().add(subject);
        return createStudent(student).getBody();
    }

	public ResponseEntity<List<StudentDto>> getAllStudetn() {
		
		// TODO Auto-generated method stub
		List<Student> students = studentRepo.findAll();
		List<StudentDto> studentDtos = new ArrayList<StudentDto>();
		for(Student student:students) {
			List<Subject> subjects = student.getSubjects();
			List<SubjectDto> subjectDtos = new ArrayList<SubjectDto>();
			for(Subject subject : subjects) {
				subjectDtos.add(new SubjectDto(subject.getSubjectId(),subject.getSubjectName()));
			}
			
			List<Exam> exams = student.getExams();
			List<ExamDto> examDtos = new ArrayList<ExamDto>();
			for(Exam exam :exams) {
				examDtos.add(new ExamDto(exam.getExamId(),new SubjectDto(exam.getSubject().getSubjectId(),exam.getSubject().getSubjectName())));
			}
			studentDtos.add(new StudentDto(student.getRegistrationId(),student.getStudentName(),subjectDtos,examDtos));
		}
		
		return new ResponseEntity(studentDtos, HttpStatus.OK);
	}

	public ResponseEntity<StudentDto> createStudent(Student student) {
	    Student savedStudent = studentRepo.save(student);

	    // Convert Subjects to DTOs
	    List<SubjectDto> subjectDtos = savedStudent.getSubjects().stream()
	        .map(subject -> new SubjectDto(subject.getSubjectId(), subject.getSubjectName()))
	        .collect(Collectors.toList());

	    // Convert Exams to DTOs
	    List<ExamDto> examDtos = savedStudent.getExams().stream()
	        .map(exam -> new ExamDto(
	            exam.getExamId(),
	            new SubjectDto(exam.getSubject().getSubjectId(), exam.getSubject().getSubjectName())
	        ))
	        .collect(Collectors.toList());

	    // Create final Student DTO
	    StudentDto studentDto = new StudentDto(
	        savedStudent.getRegistrationId(),
	        savedStudent.getStudentName(),
	        subjectDtos,
	        examDtos
	    );

	    return new ResponseEntity<>(studentDto, HttpStatus.CREATED);
	}


	public ResponseEntity<StudentDto> updateStudent(Student student) {
	    // Save the student
	    Student updatedStudent = studentRepo.save(student);

	    // Manually convert to StudentDto
	    List<SubjectDto> subjectDtos = updatedStudent.getSubjects().stream()
	    		.map(sub->new SubjectDto(sub.getSubjectId(),sub.getSubjectName()))
	    		.collect(Collectors.toList());

	    List<ExamDto> examDtos = new ArrayList<>();
	    for (Exam exam : updatedStudent.getExams()) {
	        Subject sub = exam.getSubject();
	        SubjectDto subjectDto = new SubjectDto(sub.getSubjectId(), sub.getSubjectName());
	        examDtos.add(new ExamDto(exam.getExamId(), subjectDto));
	    }

	    StudentDto studentDto = new StudentDto(
	            updatedStudent.getRegistrationId(),
	            updatedStudent.getStudentName(),
	            subjectDtos,
	            examDtos
	    );

	    return new ResponseEntity<>(studentDto, HttpStatus.OK);
	}


	public ResponseEntity<String> deleteStudent(String registrationId) {
		
		studentRepo.deleteById(registrationId);
		// TODO Auto-generated method stub
		return new ResponseEntity<>("Deleted",HttpStatus.OK);
	}

	public ResponseEntity<StudentDto> getStudentById(String registrationId) {
		// TODO Auto-generated method stub
		
		Student student  =  studentRepo.findById(registrationId).orElseThrow(()->new ResourceNotFoundException("Student not found with Id : " + registrationId));
		
			
//			List<Subject> subjects = student.getSubjects();
//			List<SubjectDto> subjectDtos = new ArrayList<SubjectDto>();
//			for(Subject subject: subjects) {
//				subjectDtos.add( new SubjectDto(subject.getSubjectId(), subject.getSubjectName()));
//			}
		List<SubjectDto> subjectDtos = student.getSubjects().stream()
				.map(sub-> new SubjectDto(sub.getSubjectId(),sub.getSubjectName()))
				.collect(Collectors.toList());

			List<ExamDto> examDtos = student.getExams().stream()
					.map(exam-> new ExamDto(exam.getExamId(), 
							new SubjectDto(exam.getSubject().getSubjectId(),
									exam.getSubject().getSubjectName())))
					.collect(Collectors.toList());
			
			
			
			StudentDto studentDto = new StudentDto(
					student.getRegistrationId(), 
					student.getStudentName(),
					subjectDtos, examDtos
					);
			
			return new ResponseEntity<StudentDto>(studentDto,HttpStatus.OK);
			
	
		
		
		
	}

	

}

