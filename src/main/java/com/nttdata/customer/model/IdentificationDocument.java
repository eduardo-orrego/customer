package com.nttdata.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationDocument {

    @JsonProperty(value = "type")
    private String type;

    @JsonProperty(value = "number")
    private String number;

}
