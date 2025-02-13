package jroullet83.msloans.service;

import jroullet83.msloans.Repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;


}
