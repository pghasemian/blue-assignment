package com.assignment.customer.service;

import com.assignment.customer.dto.CustomerDTO;
import com.assignment.customer.mapper.CustomerMapper;
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
    /** Repository for accessing customer data in the database. */
    private final CustomerRepository customerRepository;

    /** Mapper for converting Customer entities to CustomerDTOs. */
    private final CustomerMapper customerMapper; // Added Javadoc comment here

    /**
     * Retrieves a customer by their ID.
     *
     * @param customerId The ID of the customer.
     * @return Optional containing the customer or empty if not found.
     */
    public Optional<Customer> getCustomerById(final Long customerId) {
        return customerRepository.findById(customerId);
    }

    /**
     * Creates a new customer with the given first name and surname.
     *
     * @param firstName The customer's first name.
     * @param surName   The customer's surname.
     * @return CustomerDTO representation of the created customer.
     */
    public CustomerDTO createCustomer(
            final String firstName, final String surName) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setSurName(surName);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toDTO(savedCustomer);
    }
}
