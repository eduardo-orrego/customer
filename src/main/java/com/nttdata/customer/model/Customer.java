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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
public class Customer {

    @Id
    private String id;

    @JsonProperty(value = "type")
    @Enumerated(EnumType.STRING)
    private CustomerTypeEnum typeCustomer;

    @JsonProperty(value = "status")
    @Enumerated(EnumType.STRING)
    private StatusTypeEnum status;

    @JsonProperty(value = "address")
    private Address address;

    @JsonProperty(value = "identification_documents")
    private List<IdentificationDocument> identificationDocuments;

    @JsonProperty(value = "personal_info")
    private PersonalInfo personalInfo;

    @JsonProperty(value = "business_info")
    private BusinessInfo businessInfo;

    @JsonProperty(value = "date_created")
    private LocalDateTime dateCreated;

    @JsonProperty(value = "last_updated")
    private LocalDateTime lastUpdated;


}

