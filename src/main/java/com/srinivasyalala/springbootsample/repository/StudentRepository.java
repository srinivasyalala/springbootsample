package com.srinivasyalala.springbootsample.repository;

import com.srinivasyalala.springbootsample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByStudentId(long studentId);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByLastNameNotNull();
    public List<Student> findByGuardianEmail(String email);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    public List<Student> findByEmailAddresses(String emailId);

    //Native SQL
    @Query(nativeQuery = true, value = "SELECT * FROM schooldb.tbl_student")
    public List<Student> findByEmailAddressesNative(String emailId);

    //Native SQL with Named Parameters

    @Query(nativeQuery = true, value = "SELECT * FROM schooldb.tbl_student where email_address = :emailId")
    public List<Student> findByEmailAddressesNativeNamed(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE schooldb.tbl_student set email_address = :email where first_name = :first")
    public int updateEmailByStudentFirstName(@Param("first") String firstName, @Param("email") String emailId);
}
