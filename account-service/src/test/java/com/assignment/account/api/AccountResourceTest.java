package com.assignment.account.api;


import com.assignment.account.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AccountResourceTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountResource accountResource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testCreateAccount() {
//        AccountDTO accountDTO = new AccountDTO();
//        accountDTO.setCustomerId(1L);
//        accountDTO.setInitialCredit(100.0);
//
//        AccountResponse response = new AccountResponse("success", "Account created successfully", null);
//        when(accountService.createAccount(1L, 100.0)).thenReturn(new Account(1L, 100.0, null));
//
//        ResponseEntity<AccountResponse> responseEntity = accountResource.createAccount(accountDTO);
//
//        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//        assertEquals("success", responseEntity.getBody().getStatus());
//    }
}