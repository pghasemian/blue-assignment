package com.assignment.account.exception;

/**
 * Custom exception for handling account-related errors.
 */
public class AccountException extends RuntimeException {
    public AccountException(String message) {
        super(message);
    }
}
