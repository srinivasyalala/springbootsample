package com.srinivasyalala.springbootsample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @SequenceGenerator(name="courseidsequence", sequenceName = "courseidsequence",initialValue = 1,allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseidsequence")
    private long courseId;
    private String courseTitle;
    private Integer Credit;
}
