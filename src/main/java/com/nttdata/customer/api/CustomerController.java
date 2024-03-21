package com.nttdata.customer.api;

import com.nttdata.customer.api.request.CustomerRequest;
import com.nttdata.customer.business.CustomerService;
import com.nttdata.customer.model.Customer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.constraints.NotNull;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Class: CustomerController. <br/>
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
@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  /**
   * GET  : Get information about a specific customer.
   *
   * @param documentNumber (required)
   * @return OK (status code 200)
   */
  @Operation(
    operationId = "customerGet",
    summary = "Get information about a specific customer",
    responses = {
      @ApiResponse(responseCode = "200", description = "OK", content = {
        @Content(mediaType = "application/json",
          schema = @Schema(implementation = CustomerRequest.class))
      })
    }
  )
  @GetMapping(
    value = "",
    produces = {"application/json"}
  )
  @ResponseStatus(HttpStatus.OK)
  public Mono<Customer> customerGet(
    @NotNull @Parameter(name = "documentNumber", description = "", required = true,
      in = ParameterIn.QUERY)
    @Validated @RequestParam(value = "documentNumber") BigInteger documentNumber
  ) {
    return customerService.getCustomer(documentNumber);
  }

  /**
   * POST : Create a new customer.
   *
   * @param customer (required)
   * @return Created (status code 201)
   */
  @Operation(
    operationId = "customersPost",
    summary = "Create a new customer",
    responses = {
      @ApiResponse(responseCode = "201", description = "Created", content = {
        @Content(mediaType = "application/json",
          schema = @Schema(implementation = Customer.class))
      })
    }
  )
  @PostMapping(
    value = "",
    produces = {"application/json"},
    consumes = {"application/json"})
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Customer> customersPost(
    @Validated @RequestBody CustomerRequest customer
  ) {
    return customerService.saveCustomer(customer);
  }

  /**
   * PUT : Update a customer.
   *
   * @param customerId (required)
   * @param customer   (required)
   * @return Created (status code 200)
   */
  @Operation(
    operationId = "customersPut",
    summary = "Update a customer",
    responses = {
      @ApiResponse(responseCode = "200", description = "Updated", content = {
        @Content(mediaType = "application/json", schema = @Schema())
      })
    }
  )
  @PutMapping(
    value = "/{customerId}",
    produces = {"application/json"},
    consumes = {"application/json"})
  @ResponseStatus(HttpStatus.OK)
  public Mono<Customer> customersPut(
    @Parameter(name = "customerId", description = "", required = true, in = ParameterIn.PATH)
    @PathVariable("customerId") String customerId,
    @Validated @RequestBody CustomerRequest customer
  ) {
    return customerService.updateCustomer(customer, customerId);
  }

  /**
   * DELETE : delete a customer.
   *
   * @param customerId (required)
   * @return Created (status code 200)
   */
  @Operation(
    operationId = "customerDelete",
    summary = "Delete a customer",
    responses = {
      @ApiResponse(responseCode = "200", description = "Deleted")
    }
  )
  @DeleteMapping(
    value = "/{customerId}"
  )
  @ResponseStatus(HttpStatus.OK)
  public Mono<Void> customerDelete(
    @Parameter(name = "customerId", description = "", required = true, in = ParameterIn.PATH)
    @PathVariable("customerId") String customerId
  ) {
    return customerService.deleteCustomer(customerId);
  }

}
