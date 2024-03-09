package com.nttdata.customer.business.impl;

import com.nttdata.customer.api.request.CustomerRequest;
import com.nttdata.customer.builder.CustomerBuilder;
import com.nttdata.customer.business.CustomerService;
import com.nttdata.customer.model.Customer;
import com.nttdata.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Mono<Customer> getCustomerById(String customerId) {
        return customerRepository.findById(customerId)
            .switchIfEmpty(Mono.defer(() -> {
                log.error("No data found - customerId:".concat(customerId));
                return Mono.error(new Exception("No data found"));
            }))
            .doOnSuccess(customer -> log.info("Successful search - customerId:".concat(customerId)));
    }

    @Override
    public Mono<Customer> saveCustomer(CustomerRequest customer) {
        return Mono.just(customer)
            .map(CustomerBuilder::toEntity)
            .flatMap(customerRepository::save);
    }

}
