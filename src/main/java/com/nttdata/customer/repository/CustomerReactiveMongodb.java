package com.nttdata.customer.repository;

import com.nttdata.customer.model.Customer;
import java.math.BigInteger;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerReactiveMongodb extends ReactiveMongoRepository<Customer, String> {
    Mono<Boolean> existsByIdentificationDocumentNumber(BigInteger documentNumber);

    Mono<Customer> findByIdentificationDocumentNumber(BigInteger documentNumber);
}
