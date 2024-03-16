package com.nttdata.customer.business;

import com.nttdata.customer.api.request.CustomerRequest;
import com.nttdata.customer.model.Customer;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Mono<Customer> getCustomerById(String customerId);

    Mono<Customer> getCustomer(String documentNumber);

    Mono<Customer> saveCustomer(CustomerRequest customerRequest);

    Mono<Customer> updateCustomer(CustomerRequest customerRequest, String customerId);

    Mono<Void> deleteCustomer(String customerId);

}
