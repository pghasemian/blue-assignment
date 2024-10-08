package com.assignment.account.service;


import com.assignment.account.exception.AccountException;
import com.assignment.account.model.Account;
import com.assignment.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * Service class for account-related operations.
 */
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final RestTemplate restTemplate;

    @Value("${customer.service.url}")
    private String customerServiceUrl;

    @Value("${transaction.service.url}")
    private String transactionServiceUrl;

    /**
     * Creates a new account for a customer.
     *
     * @param account the account to create
     * @return the created Account
     */
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    /**
     * Retrieves an account by ID.
     *
     * @param accountId the ID of the account
     * @return the Account
     */
    public Account getAccount(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountException("Account with ID " + accountId + " not found."));
    }

    /**
     * Method to credit a specified amount to an account and create a transaction.
     *
     * @param accountId the ID of the account
     * @param amount    the amount to credit
     * @return updated Account
     */
    public Account creditAccount(Long accountId, Double amount) {
        Account account = getAccount(accountId);
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        // Create a transaction
        transactionServiceUrl = transactionServiceUrl + "/api/transactions"; // Assuming the endpoint is "/api/transactions"
        restTemplate.postForEntity(transactionServiceUrl, new TransactionRequest(accountId, amount), Void.class);

        return account;
    }
}
