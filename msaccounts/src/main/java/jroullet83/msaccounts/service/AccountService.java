package jroullet83.msaccounts.service;

import jroullet83.msaccounts.model.Account;
import jroullet83.msaccounts.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    Logger logger = LoggerFactory.getLogger(AccountService.class);

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccount(Integer customerId) {
        return accountRepository.getAccountByCustomerId(customerId);
    }

//    public void addAccount(Account account) {
//
//        if(account.getCustomerId() == accountRepository.getAccountByCustomerId(account.getCustomerId()).getCustomerId()) {
//            logger.error("Account already exists");
//        }
//        accountRepository.save(account);
//        logger.info("Account added");
//    }

}
