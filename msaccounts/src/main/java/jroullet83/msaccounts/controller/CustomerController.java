package jroullet83.msaccounts.controller;

import jroullet83.msaccounts.dto.CustomerIdDto;
import jroullet83.msaccounts.model.Customer;
import jroullet83.msaccounts.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customerService.findAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        logger.info("Customer {} added", customer.getEmail());
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PostMapping("/get-by-id")
    public ResponseEntity<?> getCustomerById(@RequestBody CustomerIdDto customerIdDto) {
        Optional<Customer> customer = customerService.getCustomerById(customerIdDto.getCustomerId());
        if(customer.isPresent()) {
            logger.info("Customer {} found", customerIdDto.getCustomerId());
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with ID : {}" + customerIdDto.getCustomerId());
    }

}
