package com.nttdata.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.customer.model.enums.CustomerTypeEnum;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
public class Customer {

    @Id
    private String id;

    @JsonProperty(value = "type_customer")
    @Enumerated(EnumType.STRING)
    private CustomerTypeEnum typeCustomer;

    @JsonProperty(value = "full_name")
    private String fullName;

    @JsonProperty(value = "legal_name")
    private String legalName;

    @JsonProperty(value = "dni")
    private String dni;

    @JsonProperty(value = "ruc")
    private String ruc;

    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value = "phone_number")
    private String phoneNumber;

}

