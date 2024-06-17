package com.example.StudentAppSpringRest.service;

import com.example.StudentAppSpringRest.model.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);
    Student updateStudent(Student student);
    Student deleteStudent(int id);
    Student findStudentById(int id);
    List<Student> findAllStudents();

}
