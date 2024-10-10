package com.assignment.customer.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for the Customer entity.
 * This class is used to transfer customer data between layers.
 */
@Data
@NoArgsConstructor
public class CustomerDTO {

    /** Unique identifier for the customer. */
    private Long id;

    /** Customer's first name. */
    private String firstName;

    /** Customer's surname. */
    private String surName;

    // Additional fields can be added here based on requirements
}
