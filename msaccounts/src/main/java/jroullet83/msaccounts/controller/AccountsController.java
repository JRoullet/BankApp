package jroullet83.msaccounts.controller;

import jroullet83.msaccounts.model.Accounts;
import jroullet83.msaccounts.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountsController {

    @Autowired
    private final AccountsService accountsService;

    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @PostMapping("/my-account/{customerId}")
    public ResponseEntity<Accounts> getMyAccount(@PathVariable Integer customerId) {
        if(customerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(accountsService.getAccounts(customerId), HttpStatus.OK);
        }
    }

}
