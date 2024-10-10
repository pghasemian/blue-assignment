package com.assignment.customer.repository;

import com.assignment.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for customer entity.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
