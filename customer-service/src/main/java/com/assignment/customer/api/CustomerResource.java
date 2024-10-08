package com.assignment.customer.api;

import com.assignment.customer.model.Customer;
import com.assignment.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

/**
 * REST controller for customer-related operations.
 */
@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerResource {
    private final CustomerService customerService;

    /**
     * Endpoint to get customer by ID.
     *
     * @param id Customer ID.
     * @return Customer information or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
