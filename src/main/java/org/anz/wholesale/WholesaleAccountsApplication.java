package org.anz.wholesale;

/**
 * WholesaleAccountsApplication Bootstrap class
 */


import lombok.extern.slf4j.Slf4j;
import org.anz.wholesale.entity.Account;
import org.anz.wholesale.entity.Transaction;
import org.anz.wholesale.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
@Slf4j
public class WholesaleAccountsApplication implements CommandLineRunner {

    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(WholesaleAccountsApplication.class, args);
    }

    @Override
    @Transactional
    public void run(final String... strings) throws Exception {
        log.info("DB seed values running");
        List<Account> accounts = getAllAccounts();
        IntStream.range(0, accounts.size()).forEach(index -> {
            Account account = accounts.get(index);
            if (index == 0) {
                getTransactionsForUserOne().forEach(transaction -> {
                    transaction.setAccount(account);
                    account.getTransactions().add(transaction);

                });
            } else if (index == 1) {
                getTransactionsForUserTwo().forEach(transaction -> {
                    transaction.setAccount(account);
                    account.getTransactions().add(transaction);
                });
            } else if (index == 2) {
                getTransactionsForUserThree().forEach(transaction -> {
                    transaction.setAccount(account);
                    account.getTransactions().add(transaction);
                });
            }
            accountRepository.save(account);
        });

    }

    private List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(Account.builder().userId("user1").accountNumber
                ("100001").accountName("Account IN").accountType("Saving").
                balanceDate(new Date()).currency("INR")
                .openingAvailableBalance(new BigDecimal("10")).build());
        accounts.add(Account.builder().userId("user1").accountNumber
                ("100002").accountName("Account NZ").accountType("Saving").
                balanceDate(new Date()).currency("AUD")
                .openingAvailableBalance(new BigDecimal("20")).build());
        accounts.add(Account.builder().userId("user2").accountNumber
                ("100003").accountName("Account US").accountType("Saving").
                balanceDate(new Date()).currency("USD")
                .openingAvailableBalance(new BigDecimal("30")).build());
        return accounts;
    }

    private List<Transaction> getTransactionsForUserOne() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(Transaction.builder().currency("AUD").valueDate(new
                Date()).debitAmount(new BigDecimal("100")).
                creditAmount(null).debitCredit("Debit").transactionNumber
                ("801100001").transactionNarrative("TXN 801100001").build());
        transactions.add(Transaction.builder().currency("AUD").valueDate(new
                Date()).debitAmount(new BigDecimal("200")).
                creditAmount(null).debitCredit("Debit").transactionNumber
                ("801100002").transactionNarrative("TXN 801100001").build());
        transactions.add(Transaction.builder().currency("AUD").valueDate(new
                Date()).debitAmount(new BigDecimal("300")).
                creditAmount(null).debitCredit("Debit").transactionNumber
                ("801100003").transactionNarrative("TXN 801100001").build());
        return transactions;
    }

    private List<Transaction> getTransactionsForUserTwo() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(Transaction.builder().currency("AUD").valueDate(new
                Date()).debitAmount(new BigDecimal("400")).
                creditAmount(null).debitCredit("Debit").transactionNumber
                ("801100004").transactionNarrative("TXN 801100001").build());
        transactions.add(Transaction.builder().currency("AUD").valueDate(new
                Date()).debitAmount(new BigDecimal("500")).
                creditAmount(null).debitCredit("Debit").transactionNumber
                ("801100005").transactionNarrative("TXN 801100001").build());
        return transactions;
    }

    private List<Transaction> getTransactionsForUserThree() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(Transaction.builder().currency("AUD").valueDate(new
                Date()).debitAmount(new BigDecimal("600")).
                creditAmount(null).debitCredit("Debit").transactionNumber
                ("801100006").transactionNarrative("TXN 801100001").build());
        return transactions;
    }

}
