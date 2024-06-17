package com.example.StudentAppSpringRest.service;

import com.example.StudentAppSpringRest.model.Course;

import java.util.List;

public interface CourseService {

    Course addCourse(Course course);
    Course updateCourse(Course course);
    Course deleteCourse(int id);
    Course findCourseById(int id);
    List<Course> findAllCourses();

}
