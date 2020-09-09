package com.javaguru.studentservice.domain;

import com.javaguru.studentservice.dto.StudentDto;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "courses")
public class CourseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long c_id;
    @Column(name = "c_name", nullable = false, length = 100)
    private String c_name;

    @ManyToMany
    @JoinTable(name = "studentcourse",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<StudentEntity> studentsList;

    public CourseEntity() {
    }

    public CourseEntity(Long c_id, String c_name) {
        this.c_id = c_id;
        this.c_name = c_name;
    }

    public List<StudentEntity> getStudents() {
        return studentsList;
    }

    public void setStudents(List<StudentEntity> studentsList) {
        this.studentsList = studentsList;
    }

    public Long getC_id() {
        return c_id;
    }

    public void setC_id(Long c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return Objects.equals(c_id, that.c_id) &&
                Objects.equals(c_name, that.c_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(c_id, c_name);
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                '}';
    }
}
