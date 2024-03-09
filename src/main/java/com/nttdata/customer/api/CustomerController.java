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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * GET /{customerId} : Get information about a specific customer
     *
     * @param customerId (required)
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "customersCustomerIdGet",
        summary = "Get information about a specific customer",
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerRequest.class))
            })
        }
    )
    @GetMapping(
        value = "/{customerId}",
        produces = {"application/json"}
    )
    public Mono<CustomerRequest> customersCustomerIdGet(
        @Parameter(name = "customerId", description = "", required = true, in = ParameterIn.PATH)
        @PathVariable("customerId") String customerId
    ) {
        return customerService.getCustomerById(customerId);
    }

    /**
     * POST : Create a new customer
     *
     * @param customer (optional)
     * @return Created (status code 201)
     */
    @Operation(
        operationId = "customersPost",
        summary = "Create a new customer",
        responses = {
            @ApiResponse(responseCode = "201", description = "Created", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))
            })
        }
    )
    @PostMapping(
        value = "",
        produces = {"application/json"},
        consumes = {"application/json"}
    )
    public Mono<Customer> customersPost(
        @Parameter(name = "Customer", description = "")
        @Validated @RequestBody(required = false) Customer customer
    ) {
        return customerService.saveCustomer(customer);
    }

}
