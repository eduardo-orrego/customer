package com.nttdata.customer.api.request;

import com.nttdata.customer.enums.DocumentTypeEnum;
import jakarta.validation.constraints.NotNull;
import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationDocumentRequest {

    @NotNull(message = "El campo 'identificationDocument.type' no puede ser nulo")
    private DocumentTypeEnum type;

    @NotNull(message = "El campo 'identificationDocument.number' no puede ser nulo")
    private BigInteger number;
}
