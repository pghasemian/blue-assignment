package com.assignment.account.service;

import com.assignment.account.dto.AccountDTO;
import com.assignment.account.dto.CustomerDTO;
import com.assignment.account.exception.CustomerNotFoundException;
import com.assignment.account.mapper.AccountMapper;
import com.assignment.account.model.Account;
import com.assignment.account.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.naming.ServiceUnavailableException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountMapper accountMapper;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private AccountService accountService;

    private Long customerId = 1L;
    private Double initialCredit = 1000.0;
    private Account account;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Ensure mocks are initialized
        account = new Account();
        account.setId(1L);
        account.setCustomerId(customerId);
        account.setBalance(initialCredit);
    }

    @Test
    public void testServiceUnavailableException() {
        // Simulating a service unavailable exception
        when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), isNull(), eq(CustomerDTO.class)))
                .thenThrow(new RuntimeException("Service unavailable"));

        // Expect ServiceUnavailableException
        Exception exception = assertThrows(ServiceUnavailableException.class, () -> {
            accountService.createAccount(customerId, initialCredit);
        });

        String expectedMessage = "Customer Service is unavailable.";
        assertEquals(expectedMessage, exception.getMessage());
    }
}
