package service;

import model.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);
    Student updateStudent(Student student);
    Student deleteStudent(int id);
    Student findById(int id);
    List<Student> findAllStudents();

}
