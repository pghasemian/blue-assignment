package com.assignment.account.api;

import com.assignment.account.dto.AccountDTO;
import com.assignment.account.dto.CustomerDTO;
import com.assignment.account.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.ServiceUnavailableException;
import java.util.List;

/**
 * Controller for account-related operations.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts")
public class AccountResource {

    private final AccountService accountService;
    /**
     * Endpoint to create a new account for a specified customer.
     *
     * @param customerId    the ID of the customer.
     * @param initialCredit the initial credit for the new account.
     * @return ResponseEntity containing the created AccountDTO and status.
     */
    @PostMapping("/create")
    public ResponseEntity<AccountDTO> createAccount(@RequestParam Long customerId,
                                                    @RequestParam Double initialCredit) throws ServiceUnavailableException {
        AccountDTO createdAccount = accountService.createAccount(customerId, initialCredit);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    /**
     * Endpoint to retrieve account information for a specific customer.
     *
     * @param customerId the ID of the customer.
     * @return ResponseEntity containing a list of AccountDTOs and status.
     */
    @GetMapping("/account/{customerId}")
    public ResponseEntity<CustomerDTO> getAccountsByCustomerId(@PathVariable Long customerId) throws ServiceUnavailableException {
       CustomerDTO customerDTO = accountService.getCustomerAccountInfo(customerId);
        return ResponseEntity.ok(customerDTO);
    }

}
