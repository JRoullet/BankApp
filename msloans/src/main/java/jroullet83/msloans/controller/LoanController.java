package jroullet83.msloans.controller;

import jroullet83.msloans.model.Loan;
import jroullet83.msloans.model.dto.CustomerDto;
import jroullet83.msloans.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/my-loans")
public class LoanController {

    private final LoanService loanService;

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

}
