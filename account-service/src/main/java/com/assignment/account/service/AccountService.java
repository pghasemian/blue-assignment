package com.assignment.account.service;


import com.assignment.account.dto.AccountDTO;
import com.assignment.account.dto.CustomerDTO;
import com.assignment.account.dto.TransactionDTO;
import com.assignment.account.exception.CustomerNotFoundException;
import com.assignment.account.mapper.AccountMapper;
import com.assignment.account.model.Account;
import com.assignment.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.naming.ServiceUnavailableException;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Service class for account-related operations.
 */
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final RestTemplate restTemplate;

    @Value("${customer.service.url}")
    private String customerServiceUrl;

    @Value("${transaction.service.url}")
    private String transactionServiceUrl;


    /**
     * Creates a new account for the specified customer.
     *
     * @param customerId    the ID of the customer.
     * @param initialCredit the initial credit for the new account.
     * @return the created AccountDTO.
     * @throws CustomerNotFoundException   if the customer is not found.
     * @throws ServiceUnavailableException if the customer service is unavailable.
     */
    public AccountDTO createAccount(final Long customerId, final Double initialCredit) throws ServiceUnavailableException {
        // Constructing the URL to call the Customer Service for customer details

        try {
            // Fetching customer information
            ResponseEntity<CustomerDTO> response = restTemplate.exchange(
                    customerServiceUrl + "/api/customers/" + customerId, HttpMethod.GET, null,
                    CustomerDTO.class);

            // Check if customer exists
            if (response.getStatusCode().is2xxSuccessful()) {
                CustomerDTO customerDTO = response.getBody();

                // Creating a new Account instance for the customer.
                Account account = new Account();
                account.setCustomerId(customerDTO.getId());
                account.setBalance(initialCredit);
                Account savedAccount = accountRepository.save(account);
                AccountDTO accountDTO = accountMapper.toDTO(savedAccount);
                // If initial credit is greater than zero, create a transaction for it.
                if (initialCredit > 0) {
                    // Prepare transaction DTO
                    TransactionDTO transactionDTO = new TransactionDTO();
                    transactionDTO.setAccountId(savedAccount.getId()); // Associate with the new account
                    transactionDTO.setAmount(initialCredit);

                    ResponseEntity<TransactionDTO> transactionResponse = restTemplate.postForEntity(
                            transactionServiceUrl + "/api/transactions/create", transactionDTO, TransactionDTO.class);
                    TransactionDTO newTransactionDTO = new TransactionDTO();
                    newTransactionDTO.setAccountId(transactionResponse.getBody().getAccountId());
                    newTransactionDTO.setAmount(transactionResponse.getBody().getAmount());
                    newTransactionDTO.setId(transactionResponse.getBody().getId());
                    accountDTO.setTransactions(List.of(newTransactionDTO));
                }

                return accountDTO; // Return created account as DTO
            } else {
                throw new CustomerNotFoundException("Customer with ID " + customerId + " not found.");
            }
        } catch (Exception e) {
            throw new ServiceUnavailableException("Customer Service is unavailable.");
        }
    }

    /**
     * Retrieves account information for a specific customer.
     *
     * @param customerId the ID of the customer.
     * @return DTO containing the customer's account information.
     * @throws CustomerNotFoundException   if the customer is not found.
     * @throws ServiceUnavailableException if the customer service is unavailable.
     */
    public CustomerDTO getCustomerAccountInfo(final Long customerId) throws ServiceUnavailableException {
        // Constructing the URL to call the Customer Service for customer details

        try {
            // Fetching customer information
            ResponseEntity<CustomerDTO> response = restTemplate.exchange(
                    customerServiceUrl + "/api/customers/" + customerId, HttpMethod.GET, null,
                    CustomerDTO.class);

            // Check if customer exists
            if (response.getStatusCode().is2xxSuccessful()) {
                CustomerDTO customerDTO = response.getBody();

                List<Account> accounts = accountRepository.findByCustomerId(customerId);
                List<AccountDTO> accountDTOs = accounts.stream()
                        .map(accountMapper::toDTO)
                        .collect(Collectors.toList());
                for (AccountDTO accountDTO : accountDTOs) {
                    TransactionDTO transactionResponse = restTemplate.getForObject(
                            transactionServiceUrl + "/api/transactions/" + accountDTO.getId(), TransactionDTO.class);
                    /*if (transactionResponse.getStatusCode().is2xxSuccessful()) {
                        List<TransactionDTO> transactionDTOS = new ArrayList<>();
                        transactionDTOS.add(transactionResponse.getBody());
                        accountDTO.setTransactions(transactionDTOS);
                    }*/
                }

                double balance = accountDTOs.stream().mapToDouble(AccountDTO::getBalance).sum();

                assert customerDTO != null;
                customerDTO.setBalance(balance);
                customerDTO.setAccounts(accountDTOs);
                return customerDTO;
            } else {
                throw new CustomerNotFoundException("Customer with ID " + customerId + " not found.");
            }
        } catch (Exception e) {
            throw new ServiceUnavailableException("Customer Service is unavailable.");
        }
    }
}
