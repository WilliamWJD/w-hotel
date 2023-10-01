package com.wjd.hotel.exceptions;

import com.wjd.hotel.exceptions.impl.DataIntegrityViolationExceptionApp;
import com.wjd.hotel.exceptions.impl.HotelExceptionApp;
import com.wjd.hotel.exceptions.impl.ObjectNotFoundExceptionApp;
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

    @ExceptionHandler(ObjectNotFoundExceptionApp.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundExceptionApp exception, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Erro.");
        err.setMessage(exception.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(err);
    }

    @ExceptionHandler(HotelExceptionApp.class)
    public ResponseEntity<StandardError> hotelExceptionApp(HotelExceptionApp exception, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("Erro.");
        err.setMessage(exception.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(err);
    }
}
