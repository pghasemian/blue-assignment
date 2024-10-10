package com.assignment.transaction.api;

import com.assignment.transaction.dto.TransactionDTO;
import com.assignment.transaction.mapper.TransactionMapper;
import com.assignment.transaction.model.Transactions;
import com.assignment.transaction.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/transactions")
public class TransactionResource {

    private TransactionService transactionService;
    private final TransactionMapper transactionMapper;


    /**
     *
     * @param transactionDTO
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionDTO transactionDTO) {
        Transactions transaction = transactionService.createTransaction(transactionDTO.getAccountId(), transactionDTO.getAmount());
        TransactionDTO transactionResponseDTO = transactionMapper.toDTO(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionResponseDTO);
    }

    /**
     * Endpoint to retrieve transactions for a given account.
     *
     * @param accountId the ID of the account
     * @return ResponseEntity with the list of transaction DTOs and status
     */
    @GetMapping("/{accountId}")
    public ResponseEntity<List<TransactionDTO>> getAccountTransactions(@PathVariable Long accountId) {
        List<Transactions> transactions = transactionService.getTransactionsByAccountId(accountId);
        List<TransactionDTO> transactionDTOs = transactions.stream()
                .map(transactionMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(transactionDTOs);
    }
}
