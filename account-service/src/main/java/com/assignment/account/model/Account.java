package com.assignment.account.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing an account.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    /**
     * Unique identifier for the account.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Identifier for the customer associated with this account.
     */
    private Long customerId;

    /**
     * Current balance of the account.
     */
    private double balance;
}
