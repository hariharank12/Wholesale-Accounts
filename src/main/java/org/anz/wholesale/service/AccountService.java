package org.anz.wholesale.service;

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
@Service
public class AccountService {

    private AccountRepository accountRepository;

    private TransactionRepository transactionRepository;

    @Autowired
    public AccountService(final AccountRepository accountRepository, final TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public List<Account> getAccounts(final String userId, final Pageable pageable) {
        if (userId == null) {
            throw new InvalidRequestException("UserId cannot be null");
        }
        return accountRepository.findAllAccountsByUserId(userId, pageable);
    }

    public List<Transaction> getTransactions(final String accountNumber, final Pageable pageable) {
        if (accountNumber == null) {
            throw new InvalidRequestException("AccountNumber cannot be null");
        }
        return transactionRepository.findAllTransactionsByAccountNumber(accountNumber, pageable);
    }

}
