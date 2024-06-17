package com.example.StudentAppSpringRest.service;

import com.example.StudentAppSpringRest.model.Student;
import com.example.StudentAppSpringRest.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public Student deleteStudent(int id) {
        return null;
    }

    @Override
    public Student findStudentById(int id) {
        Optional<Student> studentId = studentRepository.findById(id);

        if (studentId.isPresent()) {
            return studentId.get();
        } else {
            throw new RuntimeException("The course with the id: " + id + " was not found.");
        }
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

}
