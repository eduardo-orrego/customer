package com.nttdata.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @JsonProperty(value = "street")
    @Field(value = "street")
    private String street;

    @JsonProperty(value = "city")
    @Field(value = "city")
    private String city;

    @JsonProperty(value = "country")
    @Field(value = "country")
    private String country;

    @JsonProperty(value = "postalCode")
    @Field(value = "postalCode")
    private String postalCode;

}
