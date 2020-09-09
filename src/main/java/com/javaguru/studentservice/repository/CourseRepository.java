package com.javaguru.studentservice.repository;

import com.javaguru.studentservice.domain.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
  //  List<CourseEntity> findCourseEntitiesByStudents(String course);
}
