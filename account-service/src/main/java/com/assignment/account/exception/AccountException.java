package com.assignment.account.exception;

/**
 * Custom exception for handling account-related errors.
 */
public class AccountException extends RuntimeException {

    /**
     * Constructs a new AccountException with the specified detail message.
     *
     * @param message the detail message, which is saved for later retrieval
     *                by the {@link Throwable#getMessage()} method.
     */
    public AccountException(final String message) {
        super(message);
    }
}
