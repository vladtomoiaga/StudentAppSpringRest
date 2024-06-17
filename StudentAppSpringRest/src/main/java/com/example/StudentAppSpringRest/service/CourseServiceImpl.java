package com.example.StudentAppSpringRest.service;

import com.example.StudentAppSpringRest.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.StudentAppSpringRest.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course deleteCourse(int id) {
        Optional<Course> courseId = courseRepository.findById(id);

        if (courseId.isPresent()) {
            courseRepository.delete(courseId.get());
            return courseId.get();
        } else {
            throw new RuntimeException("The course with the id: " + id + " was not found.");
        }
    }

    @Override
    public Course findCourseById(int id) {
        Optional<Course> courseId = courseRepository.findById(id);

        if (courseId.isPresent()) {
            return courseId.get();
        } else {
            throw new RuntimeException("The course with the id: " + id + " was not found.");
        }
    }

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

}
