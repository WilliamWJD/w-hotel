package com.wjd.hotel.exceptions;

import com.wjd.hotel.exceptions.impl.DataIntegrityViolationExceptionApp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationExceptionApp.class)
    public ResponseEntity<StandardError> conflictException(DataIntegrityViolationExceptionApp exception, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.CONFLICT.value());
        err.setError("Conflito.");
        err.setMessage(exception.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(err);
    }
}
