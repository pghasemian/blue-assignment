package com.assignment.account.dto;

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
    private Long id;       // Transaction ID

    /**
     * Account ID associated with this transaction.
     */
    private Long accountId;   // Account ID associated with this transaction

    /**
     * Amount involved in the transaction.
     */
    private double amount;      // Transaction amount

}
