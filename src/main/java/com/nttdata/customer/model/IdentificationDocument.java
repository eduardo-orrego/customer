package com.nttdata.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String type;

    @JsonProperty(value = "number")
    @Field(value = "number")
    private String number;

}
