package com.example.peuspocjava.api.handler;

import com.example.peuspocjava.domain.temperature.exceptions.TemperatureNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(TemperatureNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleTemperatureNotFoundException(TemperatureNotFoundException ex) {
        return buildResponse(ex, HttpStatus.NOT_FOUND);
    }

    private <E extends RuntimeException> ResponseEntity<ErrorResponse> buildResponse(E exception, HttpStatus status) {
        return ResponseEntity
                .status(status)
                .body(new ErrorResponse(exception.getMessage()));
    }
}
