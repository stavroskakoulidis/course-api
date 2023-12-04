package com.example.courseapi.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus status, LocalDateTime timestamp, Object responseObject){
        Map<String, Object> response = new HashMap<>();

        response.put("message", message);
        response.put("status", status);
        response.put("timestamp", timestamp);
        response.put("data", responseObject);

        return new ResponseEntity<>(response, status);
    }


    public static ResponseEntity<Object> responseErrorBuilder( HttpStatus status, LocalDateTime timestamp, Map<String, String> errors){
        Map<String, Object> response = new HashMap<>();

        response.put("status", status);
        response.put("timestamp", timestamp);

        String errorMessage = "";

        for (Map.Entry<String, String> error : errors.entrySet()) {
            errorMessage += error.getValue();
            response.put("error", errorMessage);
            errorMessage += ", ";
        }

        return new ResponseEntity<>(response, status);
    }

}
