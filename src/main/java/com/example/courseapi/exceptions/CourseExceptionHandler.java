package com.example.courseapi.exceptions;

import com.example.courseapi.response.ResponseHandler;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CourseExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleInvalidArgument(MethodArgumentNotValidException exception){
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));

        return ResponseHandler.responseErrorBuilder(HttpStatus.BAD_REQUEST, LocalDateTime.now(),errors);
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<Object> courseNotFound(CourseNotFoundException exception){
        Map<String, String> error = new HashMap<>();
        error.put("message", exception.getMessage());

        return ResponseHandler.responseErrorBuilder(HttpStatus.NOT_FOUND, LocalDateTime.now(),error);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DateOrderException.class)
    public ResponseEntity<Object> wrongDateOrder(DateOrderException exception){
        Map<String, String> error = new HashMap<>();
        error.put("error", exception.getMessage());
        return ResponseHandler.responseErrorBuilder(HttpStatus.BAD_REQUEST, LocalDateTime.now(),error);
    }



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleInvalidInput(HttpMessageNotReadableException exception){
        Map<String, String> error = new HashMap<>();

        if (exception.getRootCause() instanceof DateTimeParseException){
            error.put("dateFormat","Wrong date format. Valid date format is: yyyy-MM-ddTHH-mm-ss-ns");
        }

        if (exception.getRootCause() instanceof JsonParseException){
            error.put("premium", "Wrong input for isPremium field. Valid tokens are 'true' or 'false'");
        }

        return ResponseHandler.responseErrorBuilder(HttpStatus.BAD_REQUEST, LocalDateTime.now(),error);
    }

}
