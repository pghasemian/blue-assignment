package com.assignment.transaction.service;

import com.assignment.transaction.model.Transaction;
import com.assignment.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Service class for transaction-related operations.
 */
@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final RestTemplate restTemplate;

    /**
     * Creates a transaction for an account.
     *
     * @param accountId Account ID.
     * @param amount    Amount for the transaction.
     */
    public Transaction createTransaction(Long accountId, Double amount) {
        // Validate account by calling Account Microservice
        String accountServiceUrl = "http://ACCOUNT-SERVICE/accounts/" + accountId;
        restTemplate.getForObject(accountServiceUrl, Object.class); // Throws exception if account not found

        Transaction transaction = new Transaction();
        transaction.setAccountId(accountId);
        transaction.setAmount(amount);
        return transactionRepository.save(transaction);
    }

    /**
     * Retrieves transactions by account ID.
     *
     * @param accountId Account ID.
     * @return List of transactions associated with the account.
     */
    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}
