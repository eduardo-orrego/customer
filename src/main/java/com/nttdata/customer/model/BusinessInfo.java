package com.nttdata.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessInfo {

    @JsonProperty(value = "legalName")
    @Field(value = "legalName")
    private String legalName;

    @JsonProperty(value = "tradeName")
    @Field(value = "tradeName")
    private String tradeName;

    @JsonProperty(value = "incorporationDate")
    @Field(value = "incorporationDate")
    private LocalDate incorporationDate;

    @JsonProperty(value = "website")
    @Field(value = "website")
    private String website;

    @JsonProperty(value = "phoneNumberMain")
    @Field(value = "phoneNumberMain")
    private String phoneNumberMain;

    @JsonProperty(value = "phoneNumberFax")
    @Field(value = "phoneNumberFax")
    private String phoneNumberFax;

    @JsonProperty(value = "contactInfo")
    @Field(value = "contactInfo")
    private ContactInfo contactInfo;
}
