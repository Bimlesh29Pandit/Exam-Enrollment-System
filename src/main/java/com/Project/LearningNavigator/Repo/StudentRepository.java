package com.Project.LearningNavigator.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.LearningNavigator.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {}