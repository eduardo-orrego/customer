package com.nttdata.customer.repository;

import com.nttdata.customer.model.Customer;
import java.math.BigInteger;
import reactor.core.publisher.Mono;

public interface CustomerRepository {
    Mono<Customer> findCustomer(String customerId);

    Mono<Boolean> findExistsCustomer(BigInteger documentNumber);

    Mono<Boolean> findExistsCustomer(String customerId);

    Mono<Customer> saveCustomer(Customer customer);

    Mono<Void> deleteCustomer(String customerId);
}
