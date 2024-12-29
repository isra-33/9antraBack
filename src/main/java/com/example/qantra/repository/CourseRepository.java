package com.example.qantra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.qantra.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
