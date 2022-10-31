package com.srinivasyalala.springbootsample.controller;

import com.srinivasyalala.springbootsample.entity.Student;
import com.srinivasyalala.springbootsample.service.StudentService;
import com.srinivasyalala.springbootsample.service.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceimpl;

    private final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @GetMapping(value = "/getstudents")
    public List<Student> getStudent()
    {
        LOGGER.info("HELLO BOLO GETSTUDENT");
        return studentServiceimpl.getStudent();
    }

    @PostMapping(value="/createstudent")
    public String createStudent(@Valid @RequestBody Student student)
    {
        return studentServiceimpl.saveStudent(student);
    }

    @RequestMapping(value="/getstudents/{id}", method = RequestMethod.GET)
    public Student getStudentByID(@PathVariable("id") Long Id)
    {
        return studentServiceimpl.getStudentByID(Id);
    }

    @DeleteMapping("/deletestudent/{id}")
    public String deleteStudent(@PathVariable("id") Long Id)
    {
        return studentServiceimpl.deleteStudentByID(Id);
    }

    @PutMapping("/updatestudent/{id}")
    public String updateStudent(@PathVariable("id") Long Id, @RequestBody Student student)
    {
        return studentServiceimpl.updateStudentEmail(Id, student);
    }
}
