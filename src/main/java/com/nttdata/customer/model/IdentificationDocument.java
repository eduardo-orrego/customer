package com.nttdata.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.customer.model.enums.DocumentTypeEnum;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationDocument {

    @JsonProperty(value = "type")
    @Field(value = "type")
    @Enumerated(EnumType.STRING)
    private DocumentTypeEnum type;

    @JsonProperty(value = "number")
    @Field(value = "number")
    private String number;

}
