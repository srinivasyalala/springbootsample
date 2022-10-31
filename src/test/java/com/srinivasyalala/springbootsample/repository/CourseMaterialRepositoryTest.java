package com.srinivasyalala.springbootsample.repository;

import com.srinivasyalala.springbootsample.entity.Course;
import com.srinivasyalala.springbootsample.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder().courseTitle("Spring JPA").Credit(109).build();
        CourseMaterial courseMaterial = CourseMaterial.builder().url("https://www.google.com/").course(course).build();

        courseMaterialRepository.save(courseMaterial);
    }

}