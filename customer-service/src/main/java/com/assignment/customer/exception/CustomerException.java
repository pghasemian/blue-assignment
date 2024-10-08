package com.assignment.customer.exception;

/**
 * Custom exception for handling account-related errors.
 */
public class CustomerException extends RuntimeException {
    public CustomerException(String message) {
        super(message);
    }
}
