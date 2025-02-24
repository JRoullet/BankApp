package jroullet83.msaccounts.clients;

import jroullet83.msaccounts.dto.CustomerIdDto;
import jroullet83.msaccounts.model.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="ms-loans")
public interface LoanFeignClient {

    @PostMapping( value="my-loans", consumes = "application/json")
    List<Loan> getLoansDetails(@RequestBody CustomerIdDto customerIdDto);

}
