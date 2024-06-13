package service;

import model.Student;
import repository.StudentRepository;

import java.util.List;
import java.util.Optional;

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
    public Student findById(int id) {
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
