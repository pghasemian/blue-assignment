package com.assignment.transaction.api;

import com.assignment.transaction.model.Transaction;
import com.assignment.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transactions")
public class TransactionResource {

    private TransactionService transactionService;

    @PostMapping
    public Transaction createTransaction(@RequestParam Long accountId, @RequestParam Double amount) {
        return transactionService.createTransaction(accountId, amount);
    }

    @GetMapping("/account/{accountId}")
    public List<Transaction> getAccountTransactions(@PathVariable Long accountId) {
        return transactionService.getTransactionsByAccountId(accountId);
    }
}
