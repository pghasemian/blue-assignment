package com.assignment.account.service;

import com.assignment.account.model.Account;
import com.assignment.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Service class for account-related operations.
 */
@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final RestTemplate restTemplate;

    /**
     * Creates an account for a customer.
     *
     * @param customerId The ID of the customer.
     * @param initialBalance The initial balance for the account.
     * @return The created account.
     */
    public Account createAccount(Long customerId, Double initialBalance) {
        // Validate customer by calling Customer Microservice
        String customerServiceUrl = "http://CUSTOMER-SERVICE/customers/" + customerId;
        restTemplate.getForObject(customerServiceUrl, Object.class); // Throws exception if customer not found

        Account account = new Account();
        account.setCustomerId(customerId);
        account.setBalance(initialBalance);
        return accountRepository.save(account);
    }

    /**
     * Retrieves accounts by customer ID.
     *
     * @param customerId Customer ID.
     * @return List of accounts associated with the customer.
     */
    public List<Account> getAccountsByCustomerId(Long customerId) {
        return accountRepository.findByCustomerId(customerId);
    }
}
