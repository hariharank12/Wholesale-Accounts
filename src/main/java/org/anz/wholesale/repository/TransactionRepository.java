package org.anz.wholesale.repository;

import org.anz.wholesale.entity.Account;
import org.anz.wholesale.entity.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hariharank12 on 25/11/20.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("FROM Transaction t INNER JOIN t.account a where a.accountNumber = :accountNumber order by t.valueDate desc")
    List<Transaction> findAllTransactionsByAccountNumber(@Param("accountNumber") String accountNumber, Pageable pageable);
}
