package com.javaguru.studentservice.dto;

import com.javaguru.studentservice.domain.CourseEntity;
import com.javaguru.studentservice.domain.StudentEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public class StudentDto {

    private String id;
    private String name;
    private String lastName;
    private List<CourseDto> courseList;

    @Transactional
    public List<StudentDto> getStudentDtoList(List<StudentEntity> studentList) {
        List<StudentDto> studentDtoList = new ArrayList<>();

        for (StudentEntity studentEntity : studentList) {
            courseList = new ArrayList<>();

            StudentDto studentDto = new StudentDto();
            studentDto.setId(studentEntity.getId());
            studentDto.setName(studentEntity.getName());
            studentDto.setLastName(studentEntity.getLastname());

            for (CourseEntity courseEntity : studentEntity.getCourseList()) {
                CourseDto courseDto = new CourseDto();

                courseDto.setC_id(courseEntity.getC_id());
                courseDto.setC_name(courseEntity.getC_name());
            }
            studentDto.setCourseList(courseList);
            studentDtoList.add(studentDto);
        }

        return studentDtoList;
    }

    public StudentDto() {
    }

    public StudentDto(String id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName);
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
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

    public List<CourseDto> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseDto> courseList) {
        this.courseList = courseList;
    }
}
