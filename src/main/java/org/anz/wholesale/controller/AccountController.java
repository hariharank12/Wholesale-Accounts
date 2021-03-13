package org.anz.wholesale.controller;

import lombok.extern.slf4j.Slf4j;
import org.anz.wholesale.entity.Account;
import org.anz.wholesale.entity.Transaction;
import org.anz.wholesale.exception.ResourceNotFoundException;
import org.anz.wholesale.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/**
 * Created by hariharank12 on 25/11/20.
 */
@Slf4j
@RestController
@RequestMapping("/accounts")
@Validated
public class AccountController {

    private AccountService accountService;

    @Value("${defaultPage:0}")
    private final String defaultPage = "0";

    @Value("${defaultSize:10}")
    private final String defaultSize = "10";

    @Autowired
    AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/users/{userId}")
    public ResponseEntity<List<Account>> getAccountsForUser(
            @RequestParam(value = "page", defaultValue = defaultPage)
            @PositiveOrZero int page,
            @RequestParam(value = "size", defaultValue = defaultSize) @Max
                    (value =
                    100) @Positive int size,
            @PathVariable String userId) {
        log.info("Retrieving user {} accounts with page {} and size {}",
                userId, page, size);
        Pageable pageable = PageRequest.of(page, size);
        List<Account> accounts = accountService.getAccounts(userId, pageable);
        if (CollectionUtils.isEmpty(accounts)) {
            log.error("No Accounts found for user {}", userId);
            throw new ResourceNotFoundException("No Accounts found for user "
                    + userId);
        } else {
            log.debug("Accounts {}", accounts);
        }
        return ResponseEntity.ok().body(accounts);
    }

    @GetMapping(value = "/{accountNumber}/transactions")
    public ResponseEntity<List<Transaction>> getTransactionsForAccounts
            (@RequestParam(value = "page", defaultValue = defaultPage)
             @PositiveOrZero int page,
             @RequestParam(value = "size", defaultValue = defaultSize) @Max
                     (value =
                     100) @Positive int size,
             @PathVariable @NotNull String accountNumber) {
        log.info("Request received for getTransactions() method account " +
                        "number:: {}  with page :: {}  and page size :: {}",
                accountNumber, page, size);
        List<Transaction> transactions = accountService.getTransactions
                (accountNumber, PageRequest.of(page, size));
        if (CollectionUtils.isEmpty(transactions)) {
            log.error("Invalid account number {}", accountNumber);
            throw new ResourceNotFoundException("Given accountNumber not " +
                    "found " + accountNumber);
        } else {
            log.debug("Transactions {}", transactions);
        }
        return ResponseEntity.ok().body(transactions);
    }
}
