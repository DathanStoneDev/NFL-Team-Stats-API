package com.example.nflsitescrapingapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import java.time.ZoneId;
import java.time.ZonedDateTime;


@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> handleRequestException(RequestException e) {
    HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        Exception exception = new Exception(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(exception, badRequest);
    }
}
