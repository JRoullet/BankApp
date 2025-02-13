package jroullet83.msaccounts.service;

import jroullet83.msaccounts.model.Account;
import jroullet83.msaccounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccount(Integer customerId) {
        return accountRepository.getAccountByCustomerId(customerId);
    }

    public void addAccount(Account account) {accountRepository.save(account);}

}
