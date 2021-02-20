package org.anz.wholesale.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hariharank12 on 25/11/20.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "accountId")
    @JsonBackReference
    private Account account;
    private String currency;
    private Date valueDate;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private String debitCredit;
    private String transactionNumber;
    private String transactionNarrative;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", account id =" + account.getId() +
                ", account number =" + account.getAccountNumber() +
                ", currency='" + currency + '\'' +
                ", valueDate=" + valueDate +
                ", debitAmount=" + debitAmount +
                ", creditAmount=" + creditAmount +
                ", debitCredit='" + debitCredit + '\'' +
                ", transactionNumber='" + transactionNumber + '\'' +
                ", transactionNarrative='" + transactionNarrative + '\'' +
                '}';
    }
}
