package com.example.courseapi.validation;

import com.example.courseapi.exceptions.DateOrderException;
import com.example.courseapi.models.Course;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class DateOrderValidator implements ConstraintValidator<DateOrderConstraint, Course> {

    @Override
    public void initialize(DateOrderConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(Course course, ConstraintValidatorContext context) {

        if (course.getCreatedAt() == null || course.getDeletedAt() == null) {
            return true;
        }

        if (course.getDeletedAt().isBefore(course.getCreatedAt())){
            throw new DateOrderException("deletedAt must be greater than createdAt");
        }

        return true;
    }
}