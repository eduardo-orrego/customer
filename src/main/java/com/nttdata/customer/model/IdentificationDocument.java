package com.nttdata.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationDocument {

    @Field(value = "type")
    private String type;

    @Field(value = "number")
    private String number;

}
