package jroullet83.msaccounts.clients;

import io.github.resilience4j.retry.annotation.Retry;
import jroullet83.msaccounts.dto.CustomerIdDto;
import jroullet83.msaccounts.model.Card;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="ms-cards")
@Retry(name = "for-customer-details")
public interface CardFeignClient {

    @PostMapping(value="my-cards/list", consumes = "application/json")
    List<Card> getCardsDetails(@RequestBody CustomerIdDto customerIdDto);
}
