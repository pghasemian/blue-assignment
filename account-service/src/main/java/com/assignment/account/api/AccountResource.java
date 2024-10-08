package com.assignment.account.api;

import com.assignment.account.model.Account;
import com.assignment.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * REST controller for account-related operations.
 */
@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountResource {
    private final AccountService accountService;

    /**
     * Endpoint to create an account for a customer.
     *
     * @param customerId     Customer ID.
     * @param initialBalance Initial balance for the account.
     * @return The created account.
     */
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestParam Long customerId, @RequestParam Double initialBalance) {
        Account account = accountService.createAccount(customerId, initialBalance);
        return ResponseEntity.ok(account);
    }

    /**
     * Endpoint to get accounts by customer ID.
     *
     * @param customerId Customer ID.
     * @return List of accounts associated with the customer.
     */
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Account>> getAccountsByCustomerId(@PathVariable Long customerId) {
        List<Account> accounts = accountService.getAccountsByCustomerId(customerId);
        return ResponseEntity.ok(accounts);
    }
}
