package com.nttdata.customer.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.customer.enums.BusinessSubTypeEnum;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessInfoRequest {

    @JsonProperty(value = "subType")
    private BusinessSubTypeEnum subType;

    @JsonProperty(value = "legalName")
    private String legalName;

    @JsonProperty(value = "tradeName")
    private String tradeName;

    @JsonProperty(value = "incorporationDate")
    private LocalDate incorporationDate;

    @JsonProperty(value = "website")
    private String website;

    @JsonProperty(value = "fax")
    private String fax;

}
