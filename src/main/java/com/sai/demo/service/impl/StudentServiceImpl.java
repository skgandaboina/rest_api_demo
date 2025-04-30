package com.sai.demo.service.impl;

import com.sai.demo.model.Student;
import com.sai.demo.repository.StudentRepository;
import com.sai.demo.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /*public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }*/

    @Override
    public Student findStudentById(long studentId) {
        return studentRepository.findStudentById(studentId);
    }

    @Override
    public Student findStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudentByIdAndName(long id, String name) {
        return studentRepository.findStudentByIdAndName(id,name);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public Integer deleteStudentById(long studentId) {
        return studentRepository.deleteStudentById(studentId);
    }

}
