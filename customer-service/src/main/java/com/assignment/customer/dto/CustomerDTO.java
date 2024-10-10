package com.assignment.customer.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for Customer entity.
 */
@Data
@NoArgsConstructor
public class CustomerDTO {

    private Long id;  // Unique identifier for the customer
    private String firstName;  // Customer's first name
    private String surName;  // Customer's surname

    // Additional fields can be added here based on requirements
}
