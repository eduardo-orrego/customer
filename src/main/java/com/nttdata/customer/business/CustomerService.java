package com.nttdata.customer.business;

import com.nttdata.customer.model.Customer;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Mono<Customer> getCustomerById(String customerId);

    Mono<Customer> saveCustomer(Customer customer);
}
