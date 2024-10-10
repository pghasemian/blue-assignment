package com.assignment.transaction.repository;

import com.assignment.transaction.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for transaction entity.
 */
public interface TransactionRepository extends
        JpaRepository<Transactions, Long> {

    /**
     * Finds all transactions associated with a specific account ID.
     *
     * @param accountId the ID of the acc for which to retrieve transactions.
     * @return a list of Transactions associated with the given account ID.
     */
    List<Transactions> findByAccountId(Long accountId);
}
