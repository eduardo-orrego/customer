package com.nttdata.customer.repository;

import com.nttdata.customer.model.Customer;
import java.math.BigInteger;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Class: CustomerReactiveMongodb. <br/>
 * <b>Bootcamp NTTDATA</b><br/>
 *
 * @author NTTDATA
 * @version 1.0
 *   <u>Developed by</u>:
 *   <ul>
 *   <li>Developer Carlos</li>
 *   </ul>
 * @since 1.0
 */
@Repository
public interface CustomerReactiveMongodb extends ReactiveMongoRepository<Customer, String> {
  Mono<Boolean> existsByIdentificationDocumentNumber(BigInteger documentNumber);

  Mono<Customer> findByIdentificationDocumentNumber(BigInteger documentNumber);
}
