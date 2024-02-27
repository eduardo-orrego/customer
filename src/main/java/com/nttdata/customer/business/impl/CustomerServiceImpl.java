package com.nttdata.customer.business.impl;

import com.nttdata.customer.business.CustomerService;
import com.nttdata.customer.model.Customer;
import com.nttdata.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Mono<Customer> getCustomerById(String customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public Mono<Customer> saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

}
