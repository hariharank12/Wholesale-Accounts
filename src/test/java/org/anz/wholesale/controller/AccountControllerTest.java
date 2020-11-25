package org.anz.wholesale.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.anz.wholesale.entity.Account;
import org.anz.wholesale.entity.Transaction;
import org.anz.wholesale.repository.AccountRepository;
import org.anz.wholesale.repository.TransactionRepository;
import org.anz.wholesale.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by hariharank12 on 25/11/20.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @MockBean
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private TransactionRepository transactionRepository;

    @Autowired
    private MockMvc mvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void givenUserId_whenGetAccount_thenReturnJsonArray() throws Exception {
        given(accountService.getAccounts("user1", PageRequest.of(0, 10))).willReturn(getAccountList());
        mvc.perform(get("/accounts/{userId}?page=0&size=10", "user1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void givenUserId_whenGetAccount_thenThrowResourceNotFoundException() throws Exception {
        String userId = "user30x";
        mvc.perform(get("/accounts/{userId}?page=0&size=10", userId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("No Accounts found for user "+ userId))
                .andExpect(jsonPath("$.errorReason").value("Not Found"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void givenAccountNumber_whenGetTransaction_thenReturnJsonArray() throws Exception {
        String accountNumber = getAccountList().get(0).getAccountNumber();
        given(accountService.getAccounts("user1", PageRequest.of(0, 10))).willReturn(getAccountList());
        given(accountService.getTransactions(accountNumber, PageRequest.of(0, 10))).willReturn(getTxnList());
        mvc.perform(get("/accounts/{accountNumber}/transactions?page=0&size=10", accountNumber)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void givenAccountNumber_whenGetTransaction_thenThrowResourceNotFoundException() throws Exception {
        String accountNumber = "accountNumber30x";
        mvc.perform(get("/accounts/{accountNumber}/transactions?page=0&size=10", accountNumber)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Given accountNumber not found "+ accountNumber))
                .andExpect(jsonPath("$.errorReason").value("Not Found"))
                .andExpect(status().isNotFound());
    }

    private List<Account> getAccountList() {
        List<Account> accountList = new ArrayList<Account>();
        Account account = Account.builder().id(1L).accountNumber("110001").accountName("Account AU").build();
        accountList.add(account);
        return accountList;
    }

    private List<Transaction> getTxnList() {
        List<Transaction> txnList = new ArrayList<Transaction>();
        Account account = Account.builder().id(1L).accountNumber("110001").accountName("Account AU").build();
        Transaction txn = Transaction.builder().account(account).build();
        txnList.add(txn);
        return txnList;
    }


}
