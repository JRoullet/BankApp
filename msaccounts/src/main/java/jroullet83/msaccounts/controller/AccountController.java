package jroullet83.msaccounts.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jroullet83.msaccounts.model.Account;
import jroullet83.msaccounts.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/my-account")
public class AccountController {

    @Autowired
    private final AccountService accountService;

    private final static Logger logger = LoggerFactory.getLogger(AccountController.class);

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<Account> getMyAccount(@PathVariable Integer customerId) throws JsonProcessingException {
        if(customerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            Account account = accountService.getAccount(customerId);

            if (account != null) {
                logger.info("Account found with id " + account.getAccountNumber()); // If getAccountNumber (@Getter) doesn't work -> Check Lombok
                return new ResponseEntity<>(account, HttpStatus.OK);
            }
                logger.info("Account not found with customerId " + customerId);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @PostMapping("/add")
//    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
//        if(account==null) {
//            logger.info("Account is null");
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        accountService.addAccount(account);
//        return new ResponseEntity<>(account, HttpStatus.OK);
//    }

}
