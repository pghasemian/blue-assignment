package com.assignment.transaction.api;

import com.assignment.transaction.dto.TransactionDTO;
import com.assignment.transaction.mapper.TransactionMapper;
import com.assignment.transaction.model.Transactions;
import com.assignment.transaction.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for managing transaction-related operations.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/transactions")
public class TransactionResource {

    /**
     * Service to manage transaction operations.
     */
    private final TransactionService transactionService;

    /**
     * Mapper to convert between entity and DTO.
     */
    private final TransactionMapper transactionMapper;

    /**
     * Endpoint to create a new transaction.
     *
     * @param transactionDTO the transaction details from the request body
     * @return ResponseEntity containing the created transaction DTO and HTTP status
     */
    @Operation(hidden = true)
    @PostMapping("/create")
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionDTO transactionDTO) {
        // Create the transaction using the provided account ID and amount
        Transactions transaction = transactionService.createTransaction(
                transactionDTO.getAccountId(), transactionDTO.getAmount());

        // Map the transaction entity to its corresponding DTO
        TransactionDTO transactionResponseDTO = transactionMapper.toDTO(transaction);

        // Return the created transaction with HTTP status 201 (Created)
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionResponseDTO);
    }

    /**
     * Endpoint to retrieve all transactions for a given account.
     *
     * @param accountId the ID of the account to retrieve transactions for
     * @return ResponseEntity containing the list of transaction DTOs and HTTP status
     */
    @GetMapping("/{accountId}")
    public ResponseEntity<List<TransactionDTO>> getAccountTransactions(@PathVariable Long accountId) {
        // Fetch transactions for the specified account
        List<Transactions> transactions = transactionService.getTransactionsByAccountId(accountId);

        // Map the list of transaction entities to a list of DTOs
        List<TransactionDTO> transactionDTOs = transactions.stream()
                .map(transactionMapper::toDTO)
                .collect(Collectors.toList());

        // Return the list of transactions with HTTP status 200 (OK)
        return ResponseEntity.ok(transactionDTOs);
    }
}
