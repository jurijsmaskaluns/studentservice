package com.javaguru.studentservice.controller;

import com.javaguru.studentservice.dto.StudentDto;
import com.javaguru.studentservice.service.StudentService;
import com.javaguru.studentservice.validation.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> findAllStudents() {
        List<StudentDto> studentDtos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            studentDtos.add(new StudentDto(
                    UUID.randomUUID().toString(),
                    "TEST_USER_FIRST_NAME_" + i,
                    "TEST_USER_LAST_NAME_" + i));

        }
        return studentDtos;
    }

    @GetMapping("/{id}")
    public StudentDto findStudentById(@PathVariable String id) {
        System.out.println("Received find student by id request, id: " + id);
        return studentService.findById(id);
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto, UriComponentsBuilder builder) {
        System.out.println("Received request create student: " + studentDto);
        StudentDto response = studentService.save(studentDto);
        return ResponseEntity.created(
                builder.path("/students/{id}")
                        .buildAndExpand(response.getId()).toUri()).build();

    }

    @ResponseStatus(HttpStatus.FOUND)
    @PutMapping("/{id}")
    public StudentDto updateStudent(@RequestBody StudentDto studentDto, @PathVariable String id, UriComponentsBuilder builder) {
        System.out.println("Received id: " + id);
        System.out.println("Received request update student: " + studentDto);
        studentService.updateStudent(studentDto, id);
        return studentService.findById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
        System.out.println("Deleted id: " + id);
        System.out.println("Deleted request delete student: ");
        studentService.deleteStudentById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public void handleNotFound(StudentNotFoundException exception) {
        System.out.println(exception.getMessage());
    }
}
