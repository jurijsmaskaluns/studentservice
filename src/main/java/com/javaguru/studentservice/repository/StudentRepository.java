package com.javaguru.studentservice.repository;

import com.javaguru.studentservice.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
  //  List<StudentEntity> findCourseByStudent(String student);
}
