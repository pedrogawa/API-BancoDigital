package com.DigitalBank.handler;

import com.DigitalBank.error.ValidationErrorDetails;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException manvException){
        List<FieldError> fieldErrors =manvException.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String fieldMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));


        ValidationErrorDetails rnfDetails = ValidationErrorDetails.Builder
                .newBuilder()
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Falha na validacao")
                .developerMessage(manvException.getClass().getName())
                .field(fields)
                .fieldMessage(fieldMessages)
                .build();

        return new ResponseEntity<>(rnfDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrityViolationException(DataIntegrityViolationException diveException){
        ValidationErrorDetails rnfDetails = ValidationErrorDetails.Builder
                .newBuilder()
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Falha na validacao")
                .developerMessage(diveException.getClass().getName())
                .fieldMessage("Campo do Email/CPF deve ser único")
                .build();

        return new ResponseEntity<>(rnfDetails, HttpStatus.BAD_REQUEST);
    }
}


