package org.anz.wholesale.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Table(name = "ACCOUNTS", uniqueConstraints = {@UniqueConstraint(columnNames
        = {"accountNumber"})})
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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
            "account")
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Transaction> transactions;
    public List<Transaction> getTransactions() {
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        return transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balanceDate=" + balanceDate +
                ", currency='" + currency + '\'' +
                ", openingAvailableBalance=" + openingAvailableBalance +
                ", transactions size =" + getTransactions().size() +
                '}';
    }


}
