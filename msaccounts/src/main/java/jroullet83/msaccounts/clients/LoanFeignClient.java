package jroullet83.msaccounts.clients;

import io.github.resilience4j.retry.annotation.Retry;
import jroullet83.msaccounts.dto.CustomerIdDto;
import jroullet83.msaccounts.model.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="ms-loans")
@Retry(name = "for-customer-details")
public interface LoanFeignClient {

    @PostMapping( value="my-loans", consumes = "application/json")
    List<Loan> getLoansDetails(@RequestBody CustomerIdDto customerIdDto);

}
