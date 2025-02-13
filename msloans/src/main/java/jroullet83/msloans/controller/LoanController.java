package jroullet83.msloans.controller;

import jroullet83.msloans.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/my-loans")
public class LoanController {

    private final LoanService loanService;

//    @PostMapping("/")
}
