package com.nttdata.customer.business.impl;

import com.nttdata.customer.api.request.CustomerRequest;
import com.nttdata.customer.builder.CustomerBuilder;
import com.nttdata.customer.business.CustomerService;
import com.nttdata.customer.enums.CustomerTypeEnum;
import com.nttdata.customer.enums.DocumentTypeEnum;
import com.nttdata.customer.model.Customer;
import com.nttdata.customer.repository.CustomerRepository;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Mono<Customer> getCustomerById(String customerId) {
        return customerRepository.findCustomer(customerId)
            .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Customer not found - customerId: ".concat(customerId))));
    }

    @Override
    public Mono<Customer> saveCustomer(CustomerRequest customerRequest) {
        return Mono.just(customerRequest)
            .flatMap(this::validateCustomerData)
            .flatMap(customer ->
                customerRepository.findExistsCustomer(customerRequest.getIdentificationDocument().getNumber())
                    .flatMap(aBoolean -> {
                        if (Boolean.FALSE.equals(aBoolean)) {
                            return customerRepository.saveCustomer(CustomerBuilder.toEntity(customerRequest, null));
                        }
                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST,
                            "There is another customer with the same Document Number: "
                                .concat(customerRequest.getIdentificationDocument().getNumber().toString())));
                    }));

    }

    @Override
    public Mono<Customer> updateCustomer(CustomerRequest customerRequest, String customerId) {

        return Mono.just(customerRequest)
            .flatMap(this::validateCustomerData)
            .flatMap(newCustomer -> this.getCustomerById(customerId)
                .flatMap(currentCustomer -> {
                    if (newCustomer.getIdentificationDocument().getNumber()
                        .equals(currentCustomer.getIdentificationDocument().getNumber())) {
                        return customerRepository.saveCustomer(CustomerBuilder.toEntity(customerRequest, customerId));
                    }

                    return customerRepository.findExistsCustomer(
                            customerRequest.getIdentificationDocument().getNumber())
                        .flatMap(aBoolean -> {
                            if (Boolean.FALSE.equals(aBoolean)) {
                                return customerRepository.saveCustomer(CustomerBuilder.toEntity(customerRequest, null));
                            }
                            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST,
                                "There is another customer with the same Document Number: "
                                    .concat(customerRequest.getIdentificationDocument().getNumber().toString())));
                        });
                }));

    }

    @Override
    public Mono<Void> deleteCustomer(String customerId) {
        return customerRepository.findExistsCustomer(customerId)
            .flatMap(aBoolean -> {
                if (Boolean.TRUE.equals(aBoolean)) {
                    return customerRepository.deleteCustomer(customerId);
                }
                return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Customer not found - customerId: ".concat(customerId)));
            });
    }

    private Mono<CustomerRequest> validateCustomerData(CustomerRequest customerRequest) {
        if (customerRequest.getType().equals(CustomerTypeEnum.PERSONAL)
            && Objects.isNull(customerRequest.getPersonalInfo())) {
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "El campo 'personalInfo' "
                + "no puede ser nulo cuando el campo 'type' tiene valor 'PERSONAL"));
        }

        if (customerRequest.getType().equals(CustomerTypeEnum.PERSONAL)
            && !customerRequest.getIdentificationDocument().getType().equals(DocumentTypeEnum.DNI)) {
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "El campo " +
                "'identifactionDocument.type' no puede ser diferente a DNI " +
                "cuando el campo 'type' tiene valor 'PERSONAL"));
        }

        if (customerRequest.getType().equals(CustomerTypeEnum.BUSINESS)
            && Objects.isNull(customerRequest.getBusinessInfo())) {
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "El campo 'businessInfo' "
                + "no puede ser nulo cuando el campo 'type' tiene valor 'BUSINESS"));
        }

        if (customerRequest.getType().equals(CustomerTypeEnum.BUSINESS)
            && !customerRequest.getIdentificationDocument().getType().equals(DocumentTypeEnum.RUC)) {
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "El campo " +
                "'identifactionDocument.type' no puede ser diferente a RUC " +
                "cuando el campo 'type' tiene valor 'BUSINESS"));
        }

        if (customerRequest.getIdentificationDocument().getType().equals(DocumentTypeEnum.DNI)
            && customerRequest.getIdentificationDocument().getNumber().toString().length() != 8) {
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "El campo 'number' "
                + "debe tener 8 dígitos cuando el campo 'identificationDocument.type' tiene valor DNI"));
        }


        if (customerRequest.getIdentificationDocument().getType().equals(DocumentTypeEnum.RUC)
            && customerRequest.getIdentificationDocument().getNumber().toString().length() != 11) {
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "El campo 'number' "
                + "debe tener 11 dígitos cuando el campo 'identificationDocument.type' tiene valor RUC"));
        }

        return Mono.just(customerRequest);
    }
}

