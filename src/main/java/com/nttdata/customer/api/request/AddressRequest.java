package com.nttdata.customer.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    @JsonProperty(value = "street")
    private String street;

    @JsonProperty(value = "city")
    private String city;

    @JsonProperty(value = "country")
    private String country;

    @JsonProperty(value = "postalCode")
    private String postalCode;

}
