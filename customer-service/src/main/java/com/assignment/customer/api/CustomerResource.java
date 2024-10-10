package com.assignment.customer.api;

import com.assignment.customer.dto.CustomerDTO;
import com.assignment.customer.mapper.CustomerMapper;
import com.assignment.customer.model.Customer;
import com.assignment.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.ServiceUnavailableException;
import java.util.Optional;

/**
 * REST controller for customer-related operations.
 */
@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerResource {

    /** Service for handling customer operations. */
    private final CustomerService customerService; // Added period here
    /** Mapper for converting Customer entities to DTOs. */
    private final CustomerMapper customerMapper;   // Added period here

    /**
     * Endpoint to get customer by ID.
     *
     * @param id Customer ID.
     * @return Customer information or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(
            @PathVariable final Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(c -> ResponseEntity.ok(customerMapper.toDTO(c)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint to create a new customer.
     *
     * @param firstName the customer's first name.
     * @param surname   the customer's surname.
     * @return ResponseEntity with the created CustomerDTO.
     * @throws ServiceUnavailableException
     * if the customer service is unavailable.
     */
    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> createCustomer(
            @RequestParam final String firstName,
            @RequestParam final String surname)
            throws ServiceUnavailableException {
        CustomerDTO createdCustomer =
                customerService.createCustomer(firstName, surname);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }
}
