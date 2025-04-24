package com.Project.LearningNavigator.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.LearningNavigator.Exception.ResourceNotFoundException;
import com.Project.LearningNavigator.Model.Exam;
import com.Project.LearningNavigator.Model.Student;
import com.Project.LearningNavigator.Repo.ExamRepository;
import com.Project.LearningNavigator.Repo.StudentRepository;
@Service
public class ExamService {

	@Autowired
	private  ExamRepository examRepo;
	@Autowired
	private  StudentRepository studentRepo;

	public Exam create(Exam exam) {
		return examRepo.save(exam);
	}

	public List<Exam> getAll() {
		return examRepo.findAll();
	}

	public Exam get(String id) {
		return examRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Exam not found"));
	}

	public void delete(String id) {
		examRepo.deleteById(id);
	}

	public void registerStudentToExam(String examId, String studentId) {
		Exam exam = get(examId);
		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found"));

		if (!student.getSubjects().contains(exam.getSubject())) {
			throw new IllegalArgumentException("Student must be enrolled in the subject before registering for the exam");
		}

		student.getExams().add(exam);
		exam.getStudent().add(student);

		studentRepo.save(student);
		examRepo.save(exam);
	}

}
