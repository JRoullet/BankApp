package jroullet83.msloans.service;

import jroullet83.msloans.Repository.LoanRepository;
import jroullet83.msloans.model.Loan;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    public List<Loan> loanListing(Integer customerId) {
        List<Loan> loansByUser = loanRepository.getLoansByCustomerId(customerId);
        return loansByUser
                .stream()
                .sorted((l1, l2) -> l2.getStartDt().compareTo(l1.getStartDt()))
                .collect(Collectors.toList());
    }


}
