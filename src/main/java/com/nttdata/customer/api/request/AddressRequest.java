package com.nttdata.customer.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    private String street;

    private String city;

    private String country;

    private String postalCode;

}
