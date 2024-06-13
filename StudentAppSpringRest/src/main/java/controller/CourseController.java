package controller;

import model.Course;
import org.springframework.web.bind.annotation.*;
import service.CourseService;

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

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable int id) {
       Course course = courseService.findById(id);

       if (course == null) {
           throw new RuntimeException("The course with the id: " + id + " was not found.");
       }

       courseService.deleteCourse(id);
       return "The course with the id: " + id + " was deleted.";
    }

    @GetMapping("/course/{id}")
    public Course findCourse(@PathVariable int id) {
        Course course = courseService.findById(id);

        if (course == null) {
            throw new RuntimeException("The course with the id: " + id + " was not found.");
        }

        return course;

    }

    @GetMapping("/courses")
    public List<Course> findAll() {
        return courseService.findAllCourses();
    }

}