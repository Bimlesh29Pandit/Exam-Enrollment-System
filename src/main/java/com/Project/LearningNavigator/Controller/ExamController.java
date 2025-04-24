package com.Project.LearningNavigator.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Project.LearningNavigator.Model.Exam;
import com.Project.LearningNavigator.Service.ExamService;
import com.Project.LearningNavigator.dto.ExamDto;
import com.Project.LearningNavigator.dto.SubjectDto;

@RestController
@RequestMapping("/exams")
public class ExamController {
	@Autowired
    private  ExamService examService;

    @PostMapping("/{examId}")
    public ResponseEntity<String> registerToExam(
            @PathVariable String examId,
            @RequestParam String studentId) {
        examService.registerStudentToExam(examId, studentId);
        return ResponseEntity.ok("Student registered for exam successfully.");
    }
    
    @PostMapping
    public ResponseEntity<ExamDto> create(@RequestBody Exam exam) {
    	Exam exams = examService.create(exam);
    	ExamDto examDto = new ExamDto(exams.getExamId(),new SubjectDto(exams.getSubject().getSubjectId(),exams.getSubject().getSubjectName()));
        return ResponseEntity.ok(examDto);
    }

    @GetMapping
    public ResponseEntity<List<ExamDto>> getAll() {
    	List<ExamDto> examDtos = examService.getAll().stream()
    			.map(exam->new ExamDto(exam.getExamId(),new SubjectDto(exam.getSubject().getSubjectId(),exam.getSubject().getSubjectName())))
    			.collect(Collectors.toList());
        return ResponseEntity.ok(examDtos);
    }
}

