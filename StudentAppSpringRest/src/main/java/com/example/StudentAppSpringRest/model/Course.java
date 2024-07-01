package com.example.StudentAppSpringRest.model;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcourse")
    private int idCourse;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_owner")
    private String courseOwner;

    @Column(name = "course_room")
    private int courseRoom;

    @OneToMany(mappedBy = "favoriteCourse",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Student> students = new HashSet<>();

    public Course() {
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseOwner() {
        return courseOwner;
    }

    public void setCourseOwner(String courseOwner) {
        this.courseOwner = courseOwner;
    }

    public int getCourseRoom() {
        return courseRoom;
    }

    public void setCourseRoom(int courseRoom) {
        this.courseRoom = courseRoom;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students.clear();
        this.students.addAll(students);
    }

    @Override
    public String toString() {
        return "Course{" +
                "idcourse=" + idCourse +
                ", courseName='" + courseName + '\'' +
                ", courseOwner='" + courseOwner + '\'' +
                ", courseRoom=" + courseRoom +
                '}';
    }

}
