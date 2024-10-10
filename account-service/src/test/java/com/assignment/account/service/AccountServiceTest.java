package com.assignment.account.service;



import com.assignment.account.model.Account;
import com.assignment.account.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

//    @Mock
//    private CustomerRepository customerRepository;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testCreateAccount_Success() {
//        Customer customer = new Customer(1L, "John", "Doe");
//        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
//        Account account = accountService.createAccount(1L, 100.0);
//        assertNotNull(account);
//        assertEquals(100.0, account.getBalance());
//        verify(accountRepository).save(any(Account.class));
//    }
//
//    @Test
//    public void testCreateAccount_CustomerNotFound() {
//        when(customerRepository.findById(1L)).thenReturn(Optional.empty());
//        Exception exception = assertThrows(CustomerNotFoundException.class, () ->
//                accountService.createAccount(1L, 100.0));
//        assertEquals("Customer with ID 1 not found.", exception.getMessage());
//    }
}
