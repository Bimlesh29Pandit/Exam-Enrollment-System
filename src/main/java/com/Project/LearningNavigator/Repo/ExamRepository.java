package com.Project.LearningNavigator.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.LearningNavigator.Model.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, String> {}
