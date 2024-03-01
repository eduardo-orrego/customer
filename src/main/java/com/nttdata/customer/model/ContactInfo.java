package com.nttdata.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfo {

    @JsonProperty(value = "legal_representative_name")
    @Field(value = "legal_representative_name")
    private String legalRepresentativeName;

    @JsonProperty(value = "email")
    @Field(value = "email")
    private String email;

    @JsonProperty(value = "phone_number")
    @Field(value = "phone_number")
    private String phoneNumber;
}
