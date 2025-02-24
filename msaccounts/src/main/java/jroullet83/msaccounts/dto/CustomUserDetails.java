package jroullet83.msaccounts.dto;

import jroullet83.msaccounts.model.Account;
import jroullet83.msaccounts.model.Card;
import jroullet83.msaccounts.model.Loan;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CustomUserDetails {
    private Integer customerId;
    private List<Account> accounts;
    private List<Card> cards;
    private List<Loan> loans;

}
