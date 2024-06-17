package com.example.StudentAppSpringRest.controller;

import com.example.StudentAppSpringRest.model.Course;
import com.example.StudentAppSpringRest.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/course")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/course")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable int id) {
       Course course = courseService.findCourseById(id);

       if (course == null) {
           throw new RuntimeException("The course with the id: " + id + " was not found.");
       }

       courseService.deleteCourse(id);
       return "The course with the id: " + id + " was deleted.";
    }

    @GetMapping("/course/{id}")
    public Course findCourse(@PathVariable int id) {
        Course course = courseService.findCourseById(id);

        if (course == null) {
            throw new RuntimeException("The course with the id: " + id + " was not found.");
        }

        return course;
    }

    @GetMapping("/course")
    public List<Course> findAllCourses() {
        return courseService.findAllCourses();
    }

}