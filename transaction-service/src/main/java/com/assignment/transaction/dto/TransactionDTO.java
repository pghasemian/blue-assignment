package com.assignment.transaction.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for Transaction entity.
 */
@Data
@NoArgsConstructor
public class TransactionDTO {

    /**
     * Unique identifier for the transaction.
     */
    private Long id;

    /**
     * Unique identifier for the associated account.
     */
    private Long accountId;

    /**
     * Amount of the transaction.
     */
    private double amount;

}
