package com.assignment.transaction.exception;

/**
 * Custom exception for handling account-related errors.
 */
public class TransactionException extends RuntimeException {
    public TransactionException(String message) {
        super(message);
    }
}
