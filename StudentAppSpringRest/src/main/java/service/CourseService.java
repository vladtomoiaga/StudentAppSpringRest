package service;

import model.Course;

import java.util.List;

public interface CourseService {

    Course addCourse(Course course);
    Course updateCourse(Course course);
    Course deleteCourse(int id);
    Course findById(int id);
    List<Course> findAllCourses();

}
