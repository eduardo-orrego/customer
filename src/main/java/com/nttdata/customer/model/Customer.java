package com.nttdata.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.customer.model.enums.CustomerTypeEnum;
import com.nttdata.customer.model.enums.StatusTypeEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @JsonProperty(value = "identification_documents")
    @Field(value = "identification_documents")
    private List<IdentificationDocument> identificationDocuments;

    @JsonProperty(value = "personal_info")
    @Field(value = "personal_info")
    private PersonalInfo personalInfo;

    @JsonProperty(value = "business_info")
    @Field(value = "business_info")
    private BusinessInfo businessInfo;

    @JsonProperty(value = "date_created")
    @Field(value = "date_created")
    private LocalDateTime dateCreated;

    @JsonProperty(value = "last_updated")
    @Field(value = "last_updated")
    private LocalDateTime lastUpdated;


}

