package com.nttdata.customer.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessInfo {

    @Field(value = "subType")
    private String subType;

    @Field(value = "legalName")
    private String legalName;

    @Field(value = "tradeName")
    private String tradeName;

    @Field(value = "incorporationDate")
    private LocalDate incorporationDate;

    @Field(value = "website")
    private String website;

    @Field(value = "fax")
    private String fax;

}
