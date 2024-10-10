package com.assignment.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.ServiceUnavailableException;

/**
 * Global exception handler for the application.
 * This class handles various exceptions thrown throughout the application
 * and provides appropriate HTTP responses.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles AccountException.
     *
     * @param ex the exception to handle
     * @return ResponseEntity with error message and BAD_REQUEST status
     */
    @ExceptionHandler(AccountException.class)
    public ResponseEntity<String> handleAccountException(
            final AccountException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    /**
     * Handles CustomerNotFoundException.
     *
     * @param ex the exception to handle
     * @return ResponseEntity with error message and NOT_FOUND status
     */
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFound(
            final CustomerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    /**
     * Handles ServiceUnavailableException.
     *
     * @param ex the exception to handle
     * @return ResponseEntity with error message and SERVICE_UNAVAILABLE status
     */
    @ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity<String> handleServiceUnavailable(
            final ServiceUnavailableException ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(ex.getMessage());
    }

    /**
     * Handles general exceptions.
     *
     * @param ex the exception to handle
     * @return ResponseEntity with a generic error message
     * and INTERNAL_SERVER_ERROR status
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(final Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                "An unexpected error occurred: " + ex.getMessage());
    }

    // You can add more exception handlers for different exception types here.
}
