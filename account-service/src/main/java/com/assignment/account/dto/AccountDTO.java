package com.assignment.account.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Data Transfer Object for Account entity.
 */
@Data
@NoArgsConstructor
public class AccountDTO {

    /**
     * Unique identifier for the account.
     */
    private Long id;             // Account ID

    /**
     * Current balance of the account.
     */
    private double balance;      // Account balance

    /**
     * Unique identifier of the customer associated with this account.
     */
    private Long customerId;     // Customer ID associated with this account

    /**
     * List of transactions associated with this account.
     */
    private List<TransactionDTO> transactions;
}
