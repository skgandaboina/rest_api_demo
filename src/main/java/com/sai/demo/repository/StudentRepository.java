package com.sai.demo.repository;

import com.sai.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentById(long studentId);
    Student findStudentByName(String name);
    @Query("SELECT s FROM Student s WHERE s.id = :id AND s.name = :name")
    Student findStudentByIdAndName(long id, String name);

    int deleteStudentById(long studentId);

}
