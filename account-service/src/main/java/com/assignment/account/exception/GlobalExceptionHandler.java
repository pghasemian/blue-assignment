package com.assignment.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for the application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles AccountException.
     *
     * @param ex the exception to handle
     * @return ResponseEntity with error message and status
     */
    @ExceptionHandler(AccountException.class)
    public ResponseEntity<String> handleAccountException(AccountException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    // You can add more exception handlers for different exception types here.
}
