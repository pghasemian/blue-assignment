package com.assignment.transaction.repository;

import com.assignment.transaction.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for transaction entity.
 */
public interface TransactionRepository extends JpaRepository<Transactions, Long> {
    List<Transactions> findByAccountId(Long accountId);
}
