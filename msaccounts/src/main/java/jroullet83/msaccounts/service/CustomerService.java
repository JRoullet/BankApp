package jroullet83.msaccounts.service;

import jroullet83.msaccounts.model.Customer;
import jroullet83.msaccounts.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> findAllUsers() {
        return customerRepository.findAll();
    }

    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public void addCustomer(Customer customer) {
        logger.info("Adding customer " + customer.getEmail());
        customerRepository.save(customer);
    }
}
