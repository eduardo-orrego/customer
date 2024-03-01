package com.nttdata.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @JsonProperty(value = "postal_code")
    @Field(value = "postal_code")
    private String postalCode;

}
