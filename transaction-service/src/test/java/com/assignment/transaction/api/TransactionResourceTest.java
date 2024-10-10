package com.assignment.transaction.api;
import com.assignment.transaction.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class TransactionResourceTest {

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionResource transactionResource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testCreateTransaction() {
//        TransactionDTO transactionDTO = new TransactionDTO();
//        transactionDTO.setAccountId(1L);
//        transactionDTO.setAmount(50.0);
//
//        ResponseEntity<String> responseEntity = transactionResource.createTransaction(transactionDTO);
//
//        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//        verify(transactionService).createTransaction(any(Account.class), eq(50.0));
//    }
}