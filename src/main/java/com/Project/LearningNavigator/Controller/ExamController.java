package com.Project.LearningNavigator.Controller;

import java.util.List;

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
    public ResponseEntity<Exam> create(@RequestBody Exam exam) {
        return ResponseEntity.ok(examService.create(exam));
    }

    @GetMapping
    public ResponseEntity<List<Exam>> getAll() {
        return ResponseEntity.ok(examService.getAll());
    }
}
