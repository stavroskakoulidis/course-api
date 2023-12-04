package com.example.courseapi.service;

import com.example.courseapi.exceptions.CourseNotFoundException;
import com.example.courseapi.models.Course;
import com.example.courseapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository repository;

    @Autowired
    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        Optional<Course> course = repository.findById(id);

        if (course.isPresent()){
            return course.get();
        }else{
            throw new CourseNotFoundException("Course with id: " + id + " does not exists.");
        }
    }

    @Override
    public Course addCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public Course updateCourse(Course course, Long id) {
        Course existingCourse = repository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course with id: " + id + " does not exists."));

        existingCourse.setTitle(course.getTitle());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setStatus(course.getStatus());
        existingCourse.setPremium(course.isPremium());
        existingCourse.setCreatedAt(course.getCreatedAt());
        existingCourse.setDeletedAt(course.getDeletedAt());

        repository.save(existingCourse);

        return existingCourse;
    }

    @Override
    public Boolean deleteCourse(Long id) {
        Optional<Course> course = repository.findById(id);

        if (course.isPresent()){
            repository.deleteById(id);
            return Boolean.TRUE;
        }else{
            throw new CourseNotFoundException("Course with id: " + id + " does not exists.");
        }
    }

}
