package com.assignment.customer.service;


import com.assignment.customer.dto.CustomerDTO;
import com.assignment.customer.mapper.CustomerMapper;
import com.assignment.customer.model.Customer;
import com.assignment.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.naming.ServiceUnavailableException;
import java.util.Optional;

/**
 * Service class for managing customer data.
 */
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    /**
     * Retrieves a customer by their ID.
     *
     * @param customerId The ID of the customer.
     * @return Optional containing the customer or empty if not found.
     */
    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public CustomerDTO createCustomer(final String firstName, final String surName) {
        // Constructing the URL to call the Customer Service for customer details
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setSurName(surName);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toDTO(savedCustomer); // Return created customer as DTO
    }
}

