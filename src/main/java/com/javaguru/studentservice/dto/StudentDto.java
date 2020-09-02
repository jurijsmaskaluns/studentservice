package com.javaguru.studentservice.dto;

import com.javaguru.studentservice.domain.CourseEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StudentDto {

    private String id;
    private String name;
    private String lastName;
    private Set<CourseEntity> course = new HashSet<>();

    public StudentDto() {
    }

    public StudentDto(String id, String name, String lastName, Set<CourseEntity> course) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, course);
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", course=" + course +
                '}';
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<CourseEntity> getCourse() {
        return course;
    }

    public void setCourse(Set<CourseEntity> course) {
        this.course = course;
    }
}
