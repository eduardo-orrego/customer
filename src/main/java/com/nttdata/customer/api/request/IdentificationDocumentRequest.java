package com.nttdata.customer.api.request;

import com.nttdata.customer.enums.DocumentTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationDocumentRequest {

    @NotNull(message = "El campo 'identificationDocument.type' no puede ser nulo")
    private DocumentTypeEnum type;

    @NotBlank(message = "El campo 'identificationDocument.number' no puede ser vacío")
    private String number;
}
