package jroullet83.msaccounts.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jroullet83.msaccounts.model.Account;
import jroullet83.msaccounts.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private final AccountService accountService;

    private final static Logger logger = LoggerFactory.getLogger(AccountController.class);



    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/my-account/{customerId}")
    public ResponseEntity<Account> getMyAccount(@PathVariable Integer customerId) throws JsonProcessingException {
        if(customerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            Account account = accountService.getAccount(customerId);

            if (account != null) {
//                logger.info("Account found with id " + account.getAccountNumber());
                return new ResponseEntity<>(account, HttpStatus.OK);
            }
//                System.out.println("No account found for customerId : " + customerId);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
