package com.example.StudentAppSpringRest.controller;

import com.example.StudentAppSpringRest.model.Student;
import com.example.StudentAppSpringRest.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) {
        Student student = studentService.findStudentById(id);

        if (student == null) {
            throw new RuntimeException("The course with the id: " + id + " was not found.");
        }

        studentService.deleteStudent(id);
        return "The student with the id: " + id + " was deleted.";
    }

    @GetMapping("/student/{id}")
    public Student findStudent(@PathVariable int id) {
        Student student = studentService.findStudentById(id);

        if (student == null) {
            throw new RuntimeException("The student with the id: " + id + " was not found.");
        }

        return student;
    }

    @GetMapping("/student")
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }
}
