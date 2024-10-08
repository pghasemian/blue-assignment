package com.assignment.customer.service;


import com.assignment.customer.model.Customer;
import com.assignment.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for managing customer data.
 */
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    /**
     * Retrieves a customer by their ID.
     *
     * @param customerId The ID of the customer.
     * @return Optional containing the customer or empty if not found.
     */
    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }
}
