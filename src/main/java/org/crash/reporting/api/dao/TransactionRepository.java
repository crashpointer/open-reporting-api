package org.crash.reporting.api.dao;

import org.crash.reporting.api.model.Customer;
import org.crash.reporting.api.model.Status;
import org.crash.reporting.api.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    Optional<Transaction> findByTransactionUUID(String transactionUUID);

    Optional<Transaction> findByReferenceNo(String referenceNo);

    Optional<List<Transaction>> findByCustomer(Customer customer);

    Optional<List<Transaction>> findByStatus(Status status);

    Optional<List<Transaction>> findByCustomData(String customData);

    boolean existsByTransactionUUID(String transactionUUID);

    boolean existsByReferenceNo(String referenceNo);

}
