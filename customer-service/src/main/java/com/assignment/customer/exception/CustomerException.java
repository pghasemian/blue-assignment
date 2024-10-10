package com.assignment.customer.exception;

/**
 * Custom exception for handling customer-related errors.
 */
public class CustomerException extends RuntimeException {

    /**
     * Constructs a new CustomerException with the specified detail message.
     *
     * @param message the detail message which is saved
     *               for later retrieval by the
     *                {@link #getMessage()} method
     */
    public CustomerException(final String message) {
        super(message);
    }
}
