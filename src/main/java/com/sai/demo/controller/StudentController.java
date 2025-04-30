package com.sai.demo.controller;

import com.sai.demo.model.Student;
import com.sai.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /*public StudentController( StudentService studentService) {
        this.studentService = studentService;
    }*/

    @GetMapping("/getStudent/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "studentId") long studentId) {
        return new ResponseEntity<>(studentService.findStudentById(studentId), HttpStatus.OK);
    }

    @GetMapping("/getStudent")
    public ResponseEntity<Student> getStudentByIdAndName(@RequestParam Long id,
                                                    @RequestParam(required = false) String name) {
        if (name == null) {
            return new ResponseEntity<>(studentService.findStudentById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(studentService.findStudentByIdAndName(id, name), HttpStatus.OK);
        }
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/deleteStudent/{studentId}")
    public ResponseEntity<Integer> deleteStudent(@PathVariable(value = "studentId") long studentId) {
        return new ResponseEntity<>(studentService.deleteStudentById(studentId), HttpStatus.OK);
    }
}
