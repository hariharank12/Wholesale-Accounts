package org.anz.wholesale.repository;

import org.anz.wholesale.entity.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hariharank12 on 25/11/20.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,
        Long> {

    /**
     * Find all transactions by account number list.
     *
     * @param accountNumber the account number
     * @param pageable      the pageable
     * @return the list
     */
    List<Transaction> findByAccountAccountNumber(@Param("accountNumber")
                                                 final String accountNumber,
                                                 final Pageable pageable);
}
