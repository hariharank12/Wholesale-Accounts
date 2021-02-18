package org.anz.wholesale;

/**
 * WholesaleAccountsApplication Bootstrap class
 *
 */


import org.anz.wholesale.config.CustomerConfiguration;
import org.anz.wholesale.entity.Account;
import org.anz.wholesale.entity.Transaction;
import org.anz.wholesale.repository.AccountRepository;
import org.anz.wholesale.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class WholesaleAccountsApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(WholesaleAccountsApplication.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerConfiguration customerConfiguration;

    public static void main( String[] args )
    {
        SpringApplication.run(WholesaleAccountsApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        accountRepository.save(new Account(new Long(1), "user1","100001","Account IN","Saving",new Date(), "IND", new BigDecimal("10")));
        accountRepository.save(new Account(new Long(2), "user1","100001","Account IN","Saving",new Date(), "IND", new BigDecimal("20")));
        accountRepository.save(new Account(new Long(3), "user1","100001","Account IN","Saving",new Date(), "IND", new BigDecimal("30")));
        accountRepository.save(new Account(new Long(4), "user1","100006","Account IN","Saving",new Date(), "IND", new BigDecimal("40")));
        accountRepository.save(new Account(new Long(5), "user1","100006","Account IN","Saving",new Date(), "IND", new BigDecimal("50")));
        transactionRepository.save(new Transaction(new Long(1), new Account(new Long(1), "user1","100001","Account IN","Saving",new Date(), "IND", new BigDecimal("10")),"AUD", new Date(),new BigDecimal("100"),null,"Debit", "801100001","TXN 801100001"));
        transactionRepository.save(new Transaction(new Long(2), new Account(new Long(1), "user1","100001","Account IN","Saving",new Date(), "IND", new BigDecimal("10")),"AUD", new Date(),new BigDecimal("200"),null,"Debit", "801100001","TXN 801100001"));
        transactionRepository.save(new Transaction(new Long(3), new Account(new Long(1), "user1","100001","Account IN","Saving",new Date(), "IND", new BigDecimal("10")),"AUD", new Date(),new BigDecimal("300"),null,"Debit", "801100001","TXN 801100001"));
        transactionRepository.save(new Transaction(new Long(4), new Account(new Long(4), "user1","100006","Account IN","Saving",new Date(), "IND", new BigDecimal("40")),"AUD", new Date(),new BigDecimal("400"),null,"Debit", "801100001","TXN 801100001"));
        transactionRepository.save(new Transaction(new Long(5), new Account(new Long(4), "user1","100006","Account IN","Saving",new Date(), "IND", new BigDecimal("40")),"AUD", new Date(),new BigDecimal("500"),null,"Debit", "801100001","TXN 801100001"));
    }
}
