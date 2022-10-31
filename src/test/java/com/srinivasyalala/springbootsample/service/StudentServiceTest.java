package com.srinivasyalala.springbootsample.service;

import com.srinivasyalala.springbootsample.entity.Guardian;
import com.srinivasyalala.springbootsample.entity.Student;
import com.srinivasyalala.springbootsample.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    StudentServiceImpl studentServiceimpl;

    @MockBean
    StudentRepository studentRepository;

    @BeforeEach
    public void Setup()
    {
        Student student = Student.builder().firstName("Touseef")
                .studentId(20)
                .lastName("Ahmed")
                .emailId("toupi@gmail.com")
                .guardian(Guardian.builder()
                        .name("Toupi Wife")
                        .email("toupiwife@gmail.com")
                        .build()).build();

        Mockito.when(studentRepository.findById(20L)).thenReturn(Optional.ofNullable(student));
    }

    @Test
    void getStudentByIDAndMatch() {
        long ID = 20;
        Student found = studentServiceimpl.getStudentByID(Long.valueOf(ID));

        assertEquals(ID, found.getStudentId());
    }
}