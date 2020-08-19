package com.javaguru.studentservice.domain;

import com.javaguru.studentservice.dto.StudentDto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @Column(name = "s_id", unique = true, nullable = false)
    private String id;
    @Column(name = "name", nullable = false, length = 40)
    private String name;
    @Column(name = "lastname", nullable = false, length = 150)
    private String lastname;


    private Set<CourseEntity> course = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "studentcourse",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    public Set<CourseEntity> getCourseEntitySet() {
        return course;
    }


    public void setCourseEntitySet(Set<CourseEntity> courseEntitySet) {
        this.course = courseEntitySet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname);
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
