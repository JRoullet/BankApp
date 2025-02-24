package jroullet83.msaccounts.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jroullet83.msaccounts.model.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AccountRequestDto {

    private Integer customerId;
    private String accountType;
    private String bankAddress;
    private LocalDate createDt;

}
