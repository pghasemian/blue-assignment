package com.assignment.customer.service;

import com.assignment.customer.model.Customer;
import com.assignment.customer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testFindCustomerById_Success() {
//        Customer customer = new Customer(1L, "Jane", "Doe");
//        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
//
//        Customer foundCustomer = customerService.findCustomerById(1L);
//        assertNotNull(foundCustomer);
//        assertEquals("Jane", foundCustomer.getFirstName());
//    }
//
//    @Test
//    public void testFindCustomerById_NotFound() {
//        when(customerRepository.findById(1L)).thenReturn(Optional.empty());
//
//        assertThrows(CustomerNotFoundException.class, () -> {
//            customerService.findCustomerById(1L);
//        });
//    }
}
