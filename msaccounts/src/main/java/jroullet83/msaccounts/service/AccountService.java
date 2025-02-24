package jroullet83.msaccounts.service;

import jroullet83.msaccounts.model.Account;
import jroullet83.msaccounts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    public List<Account> getAccounts(Integer customerId) {
        return accountRepository.getAccountsByCustomerId(customerId);
    }

    public void addAccount(Account account) {
        accountRepository.save(account);
    }

}
