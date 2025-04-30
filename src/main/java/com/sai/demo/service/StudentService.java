package com.sai.demo.service;

import com.sai.demo.model.Student;
import jakarta.transaction.Transactional;

import java.util.List;

public interface StudentService {
    Student findStudentById(long studentId);
    Student findStudentByName(String name);

    Student saveStudent(Student student);

    Student findStudentByIdAndName(long id, String name);

    List<Student> getAllStudents();

    Integer deleteStudentById(long studentId);


}
