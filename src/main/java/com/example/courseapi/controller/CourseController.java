package com.example.courseapi.controller;

import com.example.courseapi.models.Course;
import com.example.courseapi.response.ResponseHandler;
import com.example.courseapi.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping
    public ResponseEntity<Object> getAllCourses(){
        return ResponseHandler.responseBuilder("Courses Retrieved.", HttpStatus.OK, LocalDateTime.now(), courseService.getAllCourses());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getCourseById(@PathVariable("id") Long id){
        return ResponseHandler.responseBuilder("Course " + id + " Retrieved.", HttpStatus.OK, LocalDateTime.now(), courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<Object> addCourse(@RequestBody @Valid Course course){
        return ResponseHandler.responseBuilder("Course Added.", HttpStatus.CREATED, LocalDateTime.now(), courseService.addCourse(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCourse(@RequestBody @Valid Course course, @PathVariable("id") Long id){
        return ResponseHandler.responseBuilder("Course " + id + " Updated.", HttpStatus.OK, LocalDateTime.now(), courseService.updateCourse(course, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable("id") Long id){
        return ResponseHandler.responseBuilder("Course " + id + " Deleted.", HttpStatus.OK, LocalDateTime.now(), courseService.deleteCourse(id));
    }

}
