package com.assignment.account.api;

import com.assignment.account.dto.AccountDTO;
import com.assignment.account.dto.CustomerDTO;
import com.assignment.account.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.naming.ServiceUnavailableException;

/**
 * Controller for account-related operations.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts")
public class AccountResource {

    /**
     * Service for handling account-related business logic.
     */
    private final AccountService accountService;

    /**
     * Endpoint to create a new account for a specified customer.
     *
     * @param customerId    the ID of the customer.
     * @param initialCredit the initial credit for the new account.
     * @return ResponseEntity containing the created AccountDTO and status.
     * @throws ServiceUnavailableException if the service is unavailable.
     */
    @PostMapping("/create")
    public ResponseEntity<AccountDTO> createAccount(
            @RequestParam final Long customerId,
            @RequestParam final Double initialCredit)
            throws ServiceUnavailableException {
        AccountDTO createdAccount =
                accountService.createAccount(customerId, initialCredit);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    /**
     * Endpoint to retrieve account information for a specific customer.
     *
     * @param customerId the ID of the customer.
     * @return ResponseEntity containing a CustomerDTO and status.
     * @throws ServiceUnavailableException if the service is unavailable.
     */
    @GetMapping("/account/{customerId}")
    public ResponseEntity<CustomerDTO> getAccountsByCustomerId(
            @PathVariable final Long customerId)
            throws ServiceUnavailableException {
        CustomerDTO customerDTO =
                accountService.getCustomerAccountInfo(customerId);
        return ResponseEntity.ok(customerDTO);
    }
}
