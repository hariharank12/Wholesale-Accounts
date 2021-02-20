package org.anz.wholesale.service;

import org.anz.wholesale.entity.Account;
import org.anz.wholesale.entity.Transaction;
import org.anz.wholesale.exception.InvalidRequestException;
import org.anz.wholesale.repository.AccountRepository;
import org.anz.wholesale.repository.TransactionRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
/**
 * Created by hariharank12 on 25/11/20.
 */
public class AccountServiceTest {
    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private TransactionRepository transactionRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private AccountService accountService;

    @Before
    public void setUp() {
        // With this call to initMocks we tell Mockito to process the
        // annotations
        MockitoAnnotations.initMocks(this);
        accountService = new AccountService(accountRepository,
                transactionRepository);
    }

    @Test
    public void whenAccountsFoundForUserId() {
        String userId = "user1";
        Pageable pageable = PageRequest.of(0, 10);
        Mockito.when(accountRepository.findAllAccountsByUserId(userId,
                pageable)).thenReturn(getAccountList());
        List<Account> accountList = accountService.getAccounts(userId,
                pageable);
        assertThat(accountList.size()).isGreaterThan(0);
    }

    @Test
    public void whenAccountsNotFoundForUserId() {
        String userId = "user1";
        Pageable pageable = PageRequest.of(0, 10);
        Mockito.when(accountRepository.findAllAccountsByUserId(userId,
                pageable)).thenReturn(new ArrayList<Account>());
        List<Account> accountList = accountService.getAccounts(userId,
                pageable);
        assertThat(accountList.size()).isEqualTo(0);
    }

    @Test
    public void whenUserIdIsNull() {
        String userId = null;
        thrown.expect(InvalidRequestException.class);
        thrown.expectMessage(is("UserId cannot be null"));
        Pageable pageable = PageRequest.of(0, 10);
        Mockito.when(accountRepository.findAllAccountsByUserId(userId,
                pageable)).thenReturn(new ArrayList<Account>());
        accountService.getAccounts(userId, pageable);
    }

    @Test
    public void whenTransactionFoundForAccountNo() {
        String accountNumber = "1100001";
        Pageable pageable = PageRequest.of(0, 10);
        Mockito.when(transactionRepository.findAllTransactionsByAccountNumber
                (accountNumber, pageable)).thenReturn(getTxnList());
        List<Transaction> txnList = accountService.getTransactions
                (accountNumber, pageable);
        assertThat(txnList.size()).isGreaterThan(0);
    }

    @Test
    public void whenTransactionNotFoundForAccountNo() {
        String accountNumber = "1100001";
        Pageable pageable = PageRequest.of(0, 10);
        Mockito.when(transactionRepository.findAllTransactionsByAccountNumber
                (accountNumber, pageable)).thenReturn(new
                ArrayList<Transaction>());
        List<Transaction> txnList = accountService.getTransactions
                (accountNumber, pageable);
        assertThat(txnList.size()).isEqualTo(0);
    }

    @Test
    public void whenAccountNoIsNull() {
        String accountNumber = null;
        thrown.expect(InvalidRequestException.class);
        thrown.expectMessage(is("AccountNumber cannot be null"));
        Pageable pageable = PageRequest.of(0, 10);
        Mockito.when(transactionRepository.findAllTransactionsByAccountNumber
                (accountNumber, pageable)).thenReturn(new
                ArrayList<Transaction>());
        List<Transaction> txnList = accountService.getTransactions
                (accountNumber, pageable);
        assertThat(txnList.size()).isEqualTo(0);
    }

    private List<Account> getAccountList() {
        List<Account> accountList = new ArrayList<Account>();
        Account account = Account.builder().id(1L).accountNumber("110001")
                .accountName("Account AU").build();
        accountList.add(account);
        return accountList;
    }

    private List<Transaction> getTxnList() {
        List<Transaction> txnList = new ArrayList<Transaction>();
        Account account = Account.builder().id(1L).accountNumber("110001")
                .accountName("Account AU").build();
        Transaction txn = Transaction.builder().account(account).build();
        txnList.add(txn);
        return txnList;
    }
}
