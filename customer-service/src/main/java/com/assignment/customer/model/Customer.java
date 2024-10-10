package com.assignment.customer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a customer.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    /**
     * Unique identifier for the customer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Customer's first name.
     */
    private String firstName;

    /**
     * Customer's surname.
     */
    private String surName;
}
