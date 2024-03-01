package com.nttdata.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.customer.model.enums.CustomerTypeEnum;
import com.nttdata.customer.model.enums.StatusTypeEnum;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
public class Customer {

    @Id
    private String id;

    @JsonProperty(value = "type")
    @Field(value = "type")
    @Enumerated(EnumType.STRING)
    private CustomerTypeEnum type;

    @JsonProperty(value = "status")
    @Field(value = "status")
    @Enumerated(EnumType.STRING)
    private StatusTypeEnum status;

    @JsonProperty(value = "address")
    @Field(value = "address")
    private Address address;

    @JsonProperty(value = "identificationDocuments")
    @Field(value = "identificationDocuments")
    private List<IdentificationDocument> identificationDocuments;

    @JsonProperty(value = "personalInfo")
    @Field(value = "personalInfo")
    private PersonalInfo personalInfo;

    @JsonProperty(value = "businessInfo")
    @Field(value = "businessInfo")
    private BusinessInfo businessInfo;

    @JsonProperty(value = "dateCreated")
    @Field(value = "dateCreated")
    private LocalDateTime dateCreated;

    @JsonProperty(value = "lastUpdated")
    @Field(value = "lastUpdated")
    private LocalDateTime lastUpdated;


}

