package jroullet83.msaccounts.service;

import jroullet83.msaccounts.model.Accounts;
import jroullet83.msaccounts.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {

    @Autowired
    private final AccountsRepository accountsRepository;

    public AccountsService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public Accounts getAccounts(Integer customerId) {
        return accountsRepository.getAccountsByCustomerId(customerId);
    }

}
