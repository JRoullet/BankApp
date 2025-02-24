package jroullet83.msaccounts.dto;

import jroullet83.msaccounts.model.Account;
import jroullet83.msaccounts.model.Card;
import jroullet83.msaccounts.model.Loan;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CustomUserDetails {

    private Account account;
    private List<Card> cards;
    private List<Loan> loans;

}
