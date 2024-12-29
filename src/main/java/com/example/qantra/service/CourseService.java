package com.example.qantra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qantra.interfaces.CourceServiceInterface;
import com.example.qantra.model.Course;
import com.example.qantra.repository.CourseRepository;

@Service
public class CourseService implements CourceServiceInterface {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setTitle(courseDetails.getTitle());
            course.setImage(courseDetails.getImage());
            course.setPrice(courseDetails.getPrice());
            return courseRepository.save(course);
        }
        return null;
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.findById(id).ifPresent(courseRepository::delete);
    }
}