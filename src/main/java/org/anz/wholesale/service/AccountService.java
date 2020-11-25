package org.anz.wholesale.service;

import org.anz.wholesale.entity.Account;
import org.anz.wholesale.entity.Transaction;
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

    public List<Account> getAccounts(String userId, Pageable pageable) {
        return accountRepository.findAllAccountsByUserId(userId, pageable);
    }

    public List<Transaction> getTransactions(String accountNumber, Pageable pageable) {
        return transactionRepository.findAllTransactionsByAccountNumber(accountNumber, pageable);
    }

}
