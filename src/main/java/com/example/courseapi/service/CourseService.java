package com.example.courseapi.service;

import com.example.courseapi.models.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Course addCourse(Course course);
    Course updateCourse(Course course, Long id);
    Boolean deleteCourse(Long id);
}
