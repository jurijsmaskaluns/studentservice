package com.javaguru.studentservice.dto;

import com.javaguru.studentservice.domain.CourseEntity;
import com.javaguru.studentservice.domain.StudentEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class CourseDto {
    private Long c_id;
    private String c_name;
    private List<StudentDto> studentsList;

    @Transactional
    public List<CourseDto> getStudentsDtoList (List<CourseEntity> courseEntityList){
        List<CourseDto> courseDtoList = new ArrayList<>();

        for(CourseEntity courseEntity : courseEntityList){
            studentsList = new ArrayList<>();

            CourseDto courseDto = new CourseDto();
            courseDto.setC_id(courseEntity.getC_id());
            courseDto.setC_name(courseEntity.getC_name());

            for(StudentDto studentEntity : courseDto.getStudentsList()){
                StudentDto studentDto = new StudentDto();
                studentDto.setId(studentEntity.getId());
                studentDto.setName(studentEntity.getName());
                studentDto.setLastName(studentEntity.getLastName());
                studentsList.add(studentDto);
            }
            courseDto.setStudentsList(studentsList);

            courseDtoList.add(courseDto);


        }

        return courseDtoList;
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

    public List<StudentDto> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<StudentDto> studentsList) {
        this.studentsList = studentsList;
    }
}
