package com.nttdata.customer.business.impl;

import com.nttdata.customer.api.request.CustomerRequest;
import com.nttdata.customer.builder.CustomerBuilder;
import com.nttdata.customer.business.CustomerService;
import com.nttdata.customer.model.Customer;
import com.nttdata.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
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
            .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found - " +
                "customerId: ".concat(customerId))))
            .doOnSuccess(customer -> log.info("Successful search - customerId: ".concat(customerId)));
    }

    @Override
    public Mono<Customer> saveCustomer(CustomerRequest customerRequest) {
        return Mono.just(customerRequest)
            .map(customer -> CustomerBuilder.toEntity(customer, null))
            .flatMap(customerRepository::save)
            .doOnSuccess(customer -> log.info("Successful save - customerId: ".concat(customer.getId())));

    }

    @Override
    public Mono<Customer> updateCustomer(CustomerRequest customerRequest, String customerId) {

        return customerRepository.existsById(customerId)
            .flatMap(aBoolean -> {
                if(Boolean.TRUE.equals(aBoolean)){
                    return customerRepository.save(CustomerBuilder.toEntity(customerRequest, customerId));
                }
                return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found - " +
                    "customerId: ".concat(customerId)));
            })
            .doOnSuccess(customer -> log.info("Successful update - customerId: ".concat(customerId)));
    }

    @Override
    public Mono<Void> deleteCustomer(String customerId) {
        return customerRepository.existsById(customerId)
            .flatMap(aBoolean -> {
                if (Boolean.TRUE.equals(aBoolean)) {
                    return customerRepository.deleteById(customerId);
                }
                return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found - " +
                    "customerId: ".concat(customerId)));
            })
            .doOnSuccess(customer -> log.info("Successful delete - customerId: ".concat(customerId)));
    }
}
