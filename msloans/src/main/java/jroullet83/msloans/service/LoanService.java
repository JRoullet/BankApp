package jroullet83.msloans.service;

import jroullet83.msloans.Repository.LoanRepository;
import jroullet83.msloans.controller.LoanController;
import jroullet83.msloans.model.Loan;
import jroullet83.msloans.model.dto.CustomerDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    private final static Logger logger = LoggerFactory.getLogger(LoanService.class);

    // Using RequestBody and Dto
    public List<Loan> loanListing(CustomerDto customerDto) {
        // Use the dto Field to getCustomerId
        int customerId = customerDto.getCustomerId();
        List<Loan> loansByUser = loanRepository.getLoansByCustomerId(customerId);
        return loansByUser
                .stream()
                .sorted((l1, l2) -> l2.getStartDt().compareTo(l1.getStartDt())) // Reversed date sorting : most recent to most ancient
                .collect(Collectors.toList());
    }

//    //Using PathVariable, no Dto
//    public List<Loan> loanListing(int customerId) {
//        List<Loan> loansByUser = loanRepository.getLoansByCustomerId(customerId);
//        return loansByUser
//                .stream()
//                .sorted((l1, l2) -> l2.getStartDt().compareTo(l1.getStartDt())) // Reversed date sorting : most recent to most ancient
//                .collect(Collectors.toList());
//    }

    // Add Loan
    public void addLoan(Loan loan) {
        loanRepository.save(loan);
        logger.info("New loan saved in repository");
    }

//    public void deleteLoanById(Loan loan) {
//    }

}
