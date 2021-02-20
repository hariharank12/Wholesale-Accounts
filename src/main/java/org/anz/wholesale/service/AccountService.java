package org.anz.wholesale.service;

import lombok.extern.slf4j.Slf4j;
import org.anz.wholesale.entity.Account;
import org.anz.wholesale.entity.Transaction;
import org.anz.wholesale.exception.InvalidRequestException;
import org.anz.wholesale.repository.AccountRepository;
import org.anz.wholesale.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hariharank12 on 25/11/20.
 */
@Slf4j
@Service
public class AccountService {

    private AccountRepository accountRepository;

    private TransactionRepository transactionRepository;

    /**
     * Instantiates a new Account service.
     *
     * @param accountRepository     the account repository
     * @param transactionRepository the transaction repository
     */
    @Autowired
    public AccountService(final AccountRepository accountRepository, final
    TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    /**
     * Gets accounts.
     *
     * @param userId   the user id
     * @param pageable the pageable
     * @return the accounts
     */
    public List<Account> getAccounts(final String userId, final Pageable
            pageable) {
        if (userId == null) {
            throw new InvalidRequestException("UserId cannot be null");
        }
        return accountRepository.findAllAccountsByUserId(userId, pageable);
    }

    /**
     * Gets transactions.
     *
     * @param accountNumber the account number
     * @param pageable      the pageable
     * @return the transactions
     */
    public List<Transaction> getTransactions(final String accountNumber,
                                             final Pageable pageable) {
        if (accountNumber == null) {
            throw new InvalidRequestException("AccountNumber cannot be null");
        }
        return transactionRepository.findByAccountAccountNumber
                (accountNumber, pageable);
    }

}
