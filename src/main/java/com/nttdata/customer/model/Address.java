package com.nttdata.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Field(value = "street")
    private String street;

    @Field(value = "city")
    private String city;

    @Field(value = "country")
    private String country;

    @Field(value = "postalCode")
    private String postalCode;

}
