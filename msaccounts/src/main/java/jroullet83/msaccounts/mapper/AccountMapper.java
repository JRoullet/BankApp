package jroullet83.msaccounts.mapper;

import jroullet83.msaccounts.dto.CustomUserDetails;
import jroullet83.msaccounts.dto.CustomerIdDto;
import jroullet83.msaccounts.model.Account;
import jroullet83.msaccounts.model.Card;
import jroullet83.msaccounts.model.Loan;

import java.util.List;

public class AccountMapper {
    public static CustomUserDetails mapToCustomUserDetailsDto(List<Account> accounts, CustomerIdDto customerIdDto, List<Card> cards, List<Loan> loans) {
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setCustomerId(customerIdDto.getCustomerId());
        customUserDetails.setAccounts(accounts);
        customUserDetails.setCards(cards);
        customUserDetails.setLoans(loans);
        return customUserDetails;
    }
}
