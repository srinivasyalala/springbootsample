package com.srinivasyalala.springbootsample.repository;

import com.srinivasyalala.springbootsample.entity.Guardian;
import com.srinivasyalala.springbootsample.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest - Test without commiting.
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Guardian guardian = Guardian.builder().name("Pinky").mobile("9704953958").email("pinkymickey@gmail.com").build();
        Student student = Student.builder()
                .emailId("Srinivas.Yalala@gmail.com")
                .firstName("Srinivas")
                .lastName("Yalala")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByID(){
        List<Student> studentList = studentRepository.findByStudentId(1);
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstNameContaining()
    {
        List<Student> studentList = studentRepository.findByFirstNameContaining("Sr");
        System.out.println(studentList);
    }

    @Test
    public void printStudentByLastNameNotNull(){
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByGuardianEmail(){
        List<Student> studentList = studentRepository.findByGuardianEmail("pinkymickey@gmail.com");
        System.out.println(studentList);
    }

    @Test
    public void printStudentByJPQL(){
        List<Student> student = studentRepository.findByEmailAddresses("Srinivas.Yalala@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentByNative(){
        List<Student> student = studentRepository.findByEmailAddressesNative("Srinivas.Yalala@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentByNativeNamed(){
        List<Student> student = studentRepository.findByEmailAddressesNativeNamed("Srinivas.Yalala@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateemailIDbyFirstName()
    {
        int status = studentRepository.updateEmailByStudentFirstName("Srinivas", "sri@gmail.com");
        System.out.println("Status = "+status);
    }
}