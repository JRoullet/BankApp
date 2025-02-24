package jroullet83.msaccounts.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jroullet83.msaccounts.clients.CardFeignClient;
import jroullet83.msaccounts.clients.LoanFeignClient;
import jroullet83.msaccounts.config.AccountConfiguration;
import jroullet83.msaccounts.dto.AccountRequestDto;
import jroullet83.msaccounts.dto.CustomUserDetails;
import jroullet83.msaccounts.dto.CustomerIdDto;
import jroullet83.msaccounts.mapper.AccountMapper;
import jroullet83.msaccounts.model.*;
import jroullet83.msaccounts.service.AccountService;
import jroullet83.msaccounts.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    private CustomerService customerService;

    @PostMapping("/accounts")
    public ResponseEntity<List<?>> getAccounts(@RequestBody CustomerIdDto customerIdDto) throws JsonProcessingException {
        if(customerIdDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            List<Account> accounts = accountService.getAccounts(customerIdDto.getCustomerId());

            if (accounts != null) {
                logger.info("Account(s) found with id {}", accountService.getAccounts(customerIdDto.getCustomerId())
                        .stream()
                        .map(Account::getAccountNumber)// Extracts accounts ids
                        .toList()); // If getAccountNumber (@Getter) doesn't work -> Check Lombok
                return new ResponseEntity<>(accounts, HttpStatus.OK);
            }
            logger.info("Account not found with customerId {}", customerIdDto);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //ResponseEntity<?> Returns Object or Error Message
    @PostMapping("/add")
    public ResponseEntity<?> addAccount(@RequestBody AccountRequestDto accountRequestDto) throws JsonProcessingException {

        // Check if customer is in the request
        Optional<Customer> existingCustomer = customerService.getCustomerById(accountRequestDto.getCustomerId());
        if(existingCustomer.isEmpty()) {
            logger.info("Customer not found with ID: {}", accountRequestDto.getCustomerId());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with ID : " + accountRequestDto.getCustomerId());
        }
        //Create and Set Account
        Account account = new Account();
        account.setCustomer(existingCustomer.get());
        account.setAccountType(accountRequestDto.getAccountType());
        account.setBankAddress(accountRequestDto.getBankAddress());
        account.setCreateDt(accountRequestDto.getCreateDt());
        try {
            accountService.addAccount(account);
            logger.info("Account added with id {}", account.getAccountNumber());
            return ResponseEntity.status(HttpStatus.CREATED).body(account);
        } catch (Exception e) {
            logger.error("Error while adding account {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while adding account");
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


    @CircuitBreaker(name="detailsForCustomerSupportApp") //
    @PostMapping("/my-details")
    public ResponseEntity<CustomUserDetails> getMyAccountDetails(@RequestBody CustomerIdDto customerIdDto) {

        List<Account> accounts = accountService.getAccounts(customerIdDto.getCustomerId());
        List<Card> cards = cardFeignClient.getCardsDetails(customerIdDto);
        List<Loan> loans = loanFeignClient.getLoansDetails(customerIdDto);

        CustomUserDetails customUserDetails = AccountMapper.mapToCustomUserDetailsDto(accounts,customerIdDto, cards,loans);

        return new ResponseEntity<>(customUserDetails, HttpStatus.OK);
    }

}
