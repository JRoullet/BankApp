package jroullet83.msaccounts.model;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor

public class Card {

    private int cardId;
    private int customerId;
    private String cardNumber;
    private String cardType;
    private int totalLimit;
    private int amountUsed;
    private int availableAmount;
    private Date createDt;
}
