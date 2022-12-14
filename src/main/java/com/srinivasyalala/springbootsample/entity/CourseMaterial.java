package com.srinivasyalala.springbootsample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseMaterial {
    @Id
    @SequenceGenerator(name="course_material_sequence", sequenceName = "course_material_sequence",
    allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
    private long courseMaterialId;
    private String url;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="course_id", referencedColumnName = "courseId")
    Course course;
}
