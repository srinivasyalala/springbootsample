package com.srinivasyalala.springbootsample.service;

import com.srinivasyalala.springbootsample.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    public String saveStudent(Student student);

    public List<Student> getStudent() ;

    public Student getStudentByID(Long studentId);

    public String deleteStudentByID(Long id);

    public String updateStudentEmail(Long id, Student student);
}
