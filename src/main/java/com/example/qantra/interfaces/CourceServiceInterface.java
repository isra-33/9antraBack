package com.example.qantra.interfaces;

import com.example.qantra.model.Course;
import java.util.*;
public interface CourceServiceInterface {
    List<Course> getAllCourses();
    Course addCourse(Course course);
    Course updateCourse(Long id, Course courseDetails);
    void deleteCourse(Long id);
    Course getCourseById(Long id);

}
