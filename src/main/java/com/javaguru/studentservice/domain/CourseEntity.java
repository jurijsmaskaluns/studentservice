package com.javaguru.studentservice.domain;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long c_id;

    @Column(name = "c_name", nullable = false, length = 100)
    private String c_name;



}
