package jroullet83.msloans.controller;

import jroullet83.msloans.config.LoanConfig;
import jroullet83.msloans.model.Loan;
import jroullet83.msloans.model.Properties;
import jroullet83.msloans.model.dto.CustomerDto;
import jroullet83.msloans.service.LoanService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/my-loans")
public class LoanController {

    private final LoanService loanService;
    private final LoanConfig loanConfig;


    private final static Logger logger = LoggerFactory.getLogger(LoanController.class);

    @PostMapping()
    public ResponseEntity<List<Loan>> getAllLoansByCustomerId(@RequestBody CustomerDto customerDto) {
        List<Loan> loans = loanService.loanListing(customerDto);
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<List<Loan>> getAllLoansByCustomerId(@PathVariable int customerId) {
        List<Loan> loans = loanService.loanListing(customerId);
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Loan> addLoan(@RequestBody Loan loan) {
        loanService.addLoan(loan);
        logger.info("New loan added");
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    //Properties EndPoint
    @GetMapping("/details/properties")
    public ResponseEntity<Properties> getPropertiesDetails() {
        Properties properties = new Properties(
                loanConfig.getMsg(),
                loanConfig.getBuildVersion(),
                loanConfig.getMailDetails(),
                loanConfig.getActiveBranches()
        );
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

//    @DeleteMapping()
//    public ResponseEntity<Loan> deleteLoan(@RequestBody Loan loan) {}

}
