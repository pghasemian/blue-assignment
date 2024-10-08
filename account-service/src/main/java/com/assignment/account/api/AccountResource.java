package com.assignment.account.api;

import com.assignment.account.model.Account;
import com.assignment.account.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for account-related operations.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts")
public class AccountResource {

    private final AccountService accountService;

    /**
     * Endpoint to create a new account.
     *
     * @param account the account to create
     * @return ResponseEntity with the created account and status
     */
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    /**
     * Endpoint to retrieve account information.
     *
     * @param accountId the ID of the account
     * @return ResponseEntity with the account information and status
     */
    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable Long accountId) {
        Account account = accountService.getAccount(accountId);
        return ResponseEntity.ok(account);
    }

    /**
     * Endpoint to credit an account.
     *
     * @param accountId the ID of the account
     * @param amount    the amount to credit
     * @return ResponseEntity with the updated account and status
     */
    @PostMapping("/{accountId}/credit")
    public ResponseEntity<Account> creditAccount(@PathVariable Long accountId, @RequestParam Double amount) {
        Account updatedAccount = accountService.creditAccount(accountId, amount);
        return ResponseEntity.ok(updatedAccount);
    }
}
