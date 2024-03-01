package com.nttdata.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessInfo {

    @JsonProperty(value = "legal_name")
    @Field(value = "legal_name")
    private String legalName;

    @JsonProperty(value = "trade_name")
    @Field(value = "trade_name")
    private String tradeName;

    @JsonProperty(value = "incorporation_date")
    @Field(value = "incorporation_date")
    private LocalDate incorporationDate;

    @JsonProperty(value = "website")
    @Field(value = "website")
    private String website;

    @JsonProperty(value = "phone_number_main")
    @Field(value = "phone_number_main")
    private String phoneNumberMain;

    @JsonProperty(value = "phone_number_fax")
    @Field(value = "phone_number_fax")
    private String phoneNumberFax;

    @JsonProperty(value = "contact_info")
    @Field(value = "contact_info")
    private ContactInfo contactInfo;
}
