package jroullet83.msaccounts.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

import static jroullet83.msaccounts.util.AccountNumberGenerator.generateAccountNumber;

@Entity
@Getter
@Setter
@ToString
@Table(name = "account")
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

    @PrePersist
    protected void onCreate(){
        createDt = LocalDate.now();
        LocalTime time = LocalTime.now();
        accountNumber = generateAccountNumber(customerId,createDt,accountType, time);
    }

}