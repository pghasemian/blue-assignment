package com.assignment.account.service;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Request class for transaction creation.
 */
@Data
@AllArgsConstructor
public class TransactionRequest {
    private long customerId;
    private double amount;

    // Getters and setters...
}
