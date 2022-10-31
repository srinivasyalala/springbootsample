package com.srinivasyalala.springbootsample.service;

import com.srinivasyalala.springbootsample.entity.Student;
import com.srinivasyalala.springbootsample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String saveStudent(Student student) {
       studentRepository.save(student);
       return "Success";
    }
    @Override
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByID(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public String deleteStudentByID(Long id) {
        studentRepository.deleteById(id);
        return "SUCCESS";
    }

    @Override
    public String updateStudentEmail(Long id, Student student) {
        Student stud = studentRepository.findById(id).get();
        stud.setEmailId(student.getEmailId());
        stud.setFirstName(student.getFirstName());
        studentRepository.save(stud);
        return "SUCCESS BABY !!";
    }
}
