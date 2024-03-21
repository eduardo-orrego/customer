package com.nttdata.customer.repository;

import com.nttdata.customer.model.Customer;
import java.math.BigInteger;
import reactor.core.publisher.Mono;

/**
 * Class: CustomerRepository. <br/>
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
public interface CustomerRepository {
  Mono<Customer> findCustomer(String customerId);

  Mono<Customer> findCustomer(BigInteger documentNumber);

  Mono<Boolean> findExistsCustomer(BigInteger documentNumber);

  Mono<Boolean> findExistsCustomer(String customerId);

  Mono<Customer> saveCustomer(Customer customer);

  Mono<Void> deleteCustomer(String customerId);
}
