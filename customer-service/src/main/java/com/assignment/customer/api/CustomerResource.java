package com.assignment.customer.api;

import com.assignment.customer.dto.CustomerDTO;
import com.assignment.customer.mapper.CustomerMapper;
import com.assignment.customer.model.Customer;
import com.assignment.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.ServiceUnavailableException;
import java.util.Optional;

/**
 * REST controller for customer-related operations.
 */
@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerResource {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    /**
     * Endpoint to get customer by ID.
     *
     * @param id Customer ID.
     * @return Customer information or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(c -> ResponseEntity.ok(customerMapper.toDTO(c)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestParam String firsName, @RequestParam String surname) throws ServiceUnavailableException {
        CustomerDTO createdCustomer = customerService.createCustomer(firsName, surname);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }
}
