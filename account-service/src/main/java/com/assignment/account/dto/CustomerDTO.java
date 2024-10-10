package com.assignment.account.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Data Transfer Object for Customer entity.
 */
@Data
@NoArgsConstructor
public class CustomerDTO {

    /**
     * Unique identifier for the customer.
     */
    private Long id;             // Customer ID

    /**
     * Customer's first name.
     */
    private String firstName;    // Customer's first name

    /**
     * Customer's surname.
     */
    private String surName;      // Customer's surname

    /**
     * Current balance of the customer.
     */
    private double balance;

    /**
     * List of accounts associated with the customer.
     */
    private List<AccountDTO> accounts; // Customer's accounts
}
