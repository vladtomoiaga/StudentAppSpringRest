package com.example.StudentAppSpringRest.repository;

import com.example.StudentAppSpringRest.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
