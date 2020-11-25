package org.anz.wholesale.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "ACCOUNTS")
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String accountNumber;
    private String accountName;
    private String accountType;
    private Date balanceDate;
    private String currency;
    private BigDecimal openingAvailableBalance;

}
