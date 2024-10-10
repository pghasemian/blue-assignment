package com.assignment.account.exception;

/**
 * Custom exception for handling customer not found errors.
 */
public class CustomerNotFoundException extends RuntimeException {

    /**
     * Constructs a new CustomerNotFoundException
     * with the specified detail message.
     *
     * @param message the detail message, which is saved for later retrieval
     *                by the {@link Throwable#getMessage()} method.
     */
    public CustomerNotFoundException(final String message) {
        super(message);
    }
}
