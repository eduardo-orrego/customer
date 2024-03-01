package com.nttdata.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfo {

    @JsonProperty(value = "legalRepresentativeName")
    @Field(value = "legalRepresentativeName")
    private String legalRepresentativeName;

    @JsonProperty(value = "email")
    @Field(value = "email")
    private String email;

    @JsonProperty(value = "phoneNumber")
    @Field(value = "phoneNumber")
    private String phoneNumber;
}
