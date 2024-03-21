package com.nttdata.customer.repository.impl;

import com.nttdata.customer.model.Customer;
import com.nttdata.customer.repository.CustomerReactiveMongodb;
import com.nttdata.customer.repository.CustomerRepository;
import java.math.BigInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Class: CustomerRepositoryImpl. <br/>
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
@Slf4j
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

  @Autowired
  private CustomerReactiveMongodb customerReactiveMongodb;

  @Override
  public Mono<Customer> findCustomer(String customerId) {
    return customerReactiveMongodb.findById(customerId)
      .doOnSuccess(result -> log.info("Successful find - customerId: ".concat(customerId)));
  }

  @Override
  public Mono<Customer> findCustomer(BigInteger documentNumber) {
    return customerReactiveMongodb.findByIdentificationDocumentNumber(documentNumber)
      .doOnSuccess(result -> log.info("Successful find - documentNumber: "
        .concat(documentNumber.toString())));

  }

  @Override
  public Mono<Boolean> findExistsCustomer(BigInteger documentNumber) {
    return customerReactiveMongodb.existsByIdentificationDocumentNumber(documentNumber)
      .doOnSuccess(result -> log.info("Successful find exists - documentNumber: "
        .concat(documentNumber.toString())));

  }

  @Override
  public Mono<Boolean> findExistsCustomer(String customerId) {
    return customerReactiveMongodb.existsById(customerId)
      .doOnSuccess(result -> log.info("Successful find exists - customerId: ".concat(customerId)));

  }

  @Override
  public Mono<Customer> saveCustomer(Customer customer) {
    return customerReactiveMongodb.save(customer)
      .doOnSuccess(result -> log.info("Successful save - customerId: ".concat(result.getId())));
  }

  @Override
  public Mono<Void> deleteCustomer(String customerId) {
    return customerReactiveMongodb.deleteById(customerId)
      .doOnSuccess(result -> log.info("Successful delete - customerId: ".concat(customerId)));
  }

}
