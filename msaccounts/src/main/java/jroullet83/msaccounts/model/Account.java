package jroullet83.msaccounts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(name = "account_number")
    @Id
    private long accountNumber;

    // JoinColumn to associate Account to Customer
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference // Json annotation (slave state) for recursive fields (accounts calling customer calling accounts...)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "account_type")
    private String accountType;
    @Column(name = "bank_address")
    private String bankAddress;
    @Column(name = "create_dt")
    private LocalDate createDt;

    @PrePersist
    protected void onCreate(){
        if (customer == null) {
            throw new IllegalStateException("Customer must be associated with the account.");
        }
        createDt = LocalDate.now();
        LocalTime time = LocalTime.now();
        accountNumber = generateAccountNumber(customer,createDt,accountType, time);
    }

}