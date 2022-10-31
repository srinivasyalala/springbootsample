package com.srinivasyalala.springbootsample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.security.Guard;

@Entity
@Data // Getters and Setters
@AllArgsConstructor
@NoArgsConstructor
@Builder // Builder Pattern for the class
@Table(name="tbl_student",uniqueConstraints = @UniqueConstraint(name = "emailid_unique", columnNames = "email_address")
        )
public class Student {
    @Id
    @SequenceGenerator(name="student_sequence", initialValue = 1, allocationSize = 1)
    @Column(name="STUDENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private long studentId;
    @NotBlank(message = "FirstName is mandatory")
    @Length(min = 5, max = 10, message = "FirstName should be between 5 and 10 Characters")
    private String firstName;
    private String lastName;
    @Column(name="EMAIL_ADDRESS",unique = true, nullable = false)
    private String emailId;
    @Embedded
    private Guardian guardian;

}
