package com.nttdata.customer.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.customer.enums.DocumentTypeEnum;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationDocumentRequest {

    @JsonProperty(value = "type")
    @Enumerated(EnumType.STRING)
    private DocumentTypeEnum type;

    @JsonProperty(value = "number")
    private String number;

}
