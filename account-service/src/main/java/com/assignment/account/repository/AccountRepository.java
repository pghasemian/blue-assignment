package com.assignment.account.repository;

import com.assignment.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for account entity.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * Retrieves a list of accounts associated with the given customer ID.
     *
     * @param customerId the ID of the customer whose accounts
     *                   are to be retrieved
     * @return a list of accounts belonging to the specified customer
     */
    List<Account> findByCustomerId(Long customerId);
}
