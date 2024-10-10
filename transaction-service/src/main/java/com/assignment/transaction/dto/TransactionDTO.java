package com.assignment.transaction.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for Transaction entity.
 */
@Data
@NoArgsConstructor
public class TransactionDTO {

    private Long id;
    private Long accountId;
    private double amount;

    // Additional fields can be added here based on requirements
}

