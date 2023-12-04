package com.example.courseapi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DateOrderValidator.class)
public @interface DateOrderConstraint {
    String message() default "deleted_at must be greater than created_at";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
