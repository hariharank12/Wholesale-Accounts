package org.anz.wholesale.entity;

import lombok.*;

import javax.persistence.*;
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
    private Account account;
    private String currency;
    private Date valueDate;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private String debitCredit;
    private String transactionNumber;
    private String transactionNarrative;
}
