package jroullet83.msaccounts.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jroullet83.msaccounts.clients.CardFeignClient;
import jroullet83.msaccounts.clients.LoanFeignClient;
import jroullet83.msaccounts.config.AccountConfiguration;
import jroullet83.msaccounts.dto.CustomUserDetails;
import jroullet83.msaccounts.dto.CustomerIdDto;
import jroullet83.msaccounts.model.*;
import jroullet83.msaccounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/my-account")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private final AccountService accountService;
    private final AccountConfiguration accountConfiguration;

    @Autowired
    private CardFeignClient cardFeignClient;
    @Autowired
    private LoanFeignClient loanFeignClient;

    private final static Logger logger = LoggerFactory.getLogger(AccountController.class);

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

    @PostMapping("/add")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        if(account.getCreateDt() == null) {
            logger.info("Empty account data");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Account existingAccount = accountService.getAccount(account.getCustomerId());
        if(existingAccount != null) {
            logger.info("Account already exists for customerId " + account.getCustomerId());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        else {
            accountService.addAccount(account);
            logger.info("Account created : " + account.getAccountNumber());
            return new ResponseEntity<>(account, HttpStatus.CREATED);
        }

    }

    //Properties EndPoint
    @GetMapping("/details/properties")
    public ResponseEntity<Properties> getPropertiesDetails() {
        Properties properties = new Properties(
                accountConfiguration.getMsg(),
                accountConfiguration.getBuildVersion(),
                accountConfiguration.getMailDetails(),
                accountConfiguration.getActiveBranches()
        );
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }


    @PostMapping("/my-details")
    public ResponseEntity<CustomUserDetails> getMyAccountDetails(@RequestBody CustomerIdDto customerIdDto) {

        Account account = accountService.getAccount(customerIdDto.getCustomerId());
        List<Card> cards = cardFeignClient.getCardsDetails(customerIdDto);
        List<Loan> loans = loanFeignClient.getLoansDetails(customerIdDto);

        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setAccount(account);
        customUserDetails.setCards(cards);
        customUserDetails.setLoans(loans);

        return new ResponseEntity<>(customUserDetails, HttpStatus.OK);
    }

}
