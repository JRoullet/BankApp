package jroullet83.msaccounts.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Table(name = "accounts")
public class Account {
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "account_number")
    @Id
    private long accountNumber;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "bank_address")
    private String bankAddress;
    @Column(name = "create_dt")
    private LocalDate createDt;

}