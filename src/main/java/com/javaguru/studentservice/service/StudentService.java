package com.javaguru.studentservice.service;

import com.javaguru.studentservice.domain.StudentEntity;
import com.javaguru.studentservice.dto.StudentDto;
import com.javaguru.studentservice.repository.StudentRepository;
import com.javaguru.studentservice.validation.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentDto save(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(UUID.randomUUID().toString());
        studentEntity.setName(studentDto.getName());
        studentEntity.setLastname(studentDto.getLastName());
        repository.save(studentEntity);
        return new StudentDto(studentEntity.getId(), studentEntity.getName(), studentEntity.getLastname());

    }
    public StudentDto updateStudent(StudentDto studentDto,String id){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(id);
        studentEntity.setName(studentDto.getName());
        studentEntity.setLastname(studentDto.getLastName());
        repository.save(studentEntity);
        return new StudentDto(studentEntity.getId(), studentEntity.getName(), studentEntity.getLastname());
    }



    public StudentDto findById(String id) {
        return repository.findById(id)
                .map(entity -> new StudentDto(entity.getId(), entity.getName(), entity.getLastname()))
                .orElseThrow(() -> new StudentNotFoundException("Student not found, id = " + id));
    }

    public void deleteStudentById(String id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException("Student not found, id = " + id);
        }
        repository.deleteById(id);
    }

    public List<StudentEntity> findAllStudents() {
        return repository.findAll();
    }
}
