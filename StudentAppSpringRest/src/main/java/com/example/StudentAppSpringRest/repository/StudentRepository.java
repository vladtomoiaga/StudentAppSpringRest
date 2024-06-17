package com.example.StudentAppSpringRest.repository;

import com.example.StudentAppSpringRest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
