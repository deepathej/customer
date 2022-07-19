package com.accenture.appsyncpoc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.accenture.appsyncpoc.entity.ErrorMessage;
import com.accenture.appsyncpoc.error.CustomerNotFoundException;
import com.accenture.appsyncpoc.error.CustomerWithEmailAlreadyExists;

@ControllerAdvice
@ResponseStatus
public class CustomerExceptionController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(CustomerNotFoundException.class)
  public ResponseEntity<ErrorMessage> customerNotFoundException(
      CustomerNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage()));
  }

  @ExceptionHandler(CustomerWithEmailAlreadyExists.class)
  public ResponseEntity<ErrorMessage> customerWithEmailAlreadyExists(
      CustomerWithEmailAlreadyExists exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage()));
  }

}
