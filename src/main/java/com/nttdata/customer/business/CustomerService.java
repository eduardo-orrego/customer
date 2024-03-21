package com.nttdata.customer.business;

import com.nttdata.customer.api.request.CustomerRequest;
import com.nttdata.customer.model.Customer;
import java.math.BigInteger;
import reactor.core.publisher.Mono;

/**
 * Class: CustomerService. <br/>
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
public interface CustomerService {

  Mono<Customer> getCustomer(BigInteger documentNumber);

  Mono<Customer> saveCustomer(CustomerRequest customerRequest);

  Mono<Customer> updateCustomer(CustomerRequest customerRequest, String customerId);

  Mono<Void> deleteCustomer(String customerId);

}
