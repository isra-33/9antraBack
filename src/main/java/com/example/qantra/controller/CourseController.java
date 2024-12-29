package com.example.qantra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.qantra.model.Course;
import com.example.qantra.service.CourseService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        String filename = file.getOriginalFilename();
        Path path = Paths.get("src/main/resources/static/images/" + filename);
        try {
            Files.copy(file.getInputStream(), path);
            return "File uploaded successfully: " + filename;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file";
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("")
    public Course createCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        return courseService.updateCourse(id, courseDetails);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
