package jroullet83.msaccounts.service;

import jroullet83.msaccounts.model.Customer;
import jroullet83.msaccounts.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> findAllUsers() {
        return customerRepository.findAll();
    }
}
