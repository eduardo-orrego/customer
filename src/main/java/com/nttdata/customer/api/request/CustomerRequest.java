package com.nttdata.customer.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.customer.enums.CustomerTypeEnum;
import com.nttdata.customer.enums.StatusTypeEnum;
import java.time.LocalDateTime;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    @Id
    private String id;

    @JsonProperty(value = "type")
    @Enumerated(EnumType.STRING)
    private CustomerTypeEnum type;

    @JsonProperty(value = "status")
    @Enumerated(EnumType.STRING)
    private StatusTypeEnum status;

    @JsonProperty(value = "address")
    private AddressRequest address;

    @JsonProperty(value = "identificationDocuments")
    private IdentificationDocumentRequest identificationDocument;

    @JsonProperty(value = "personalInfo")
    private PersonalInfoRequest personalInfo;

    @JsonProperty(value = "businessInfo")
    private BusinessInfoRequest businessInfo;

    @JsonProperty(value = "dateCreated")
    private LocalDateTime dateCreated;

    @JsonProperty(value = "lastUpdated")
    private LocalDateTime lastUpdated;


}

