package jroullet83.msaccounts.model;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class Loan {

    private int loanNumber;
    private int customerId;
    private Date startDt;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;
    private String createdDt;

}
