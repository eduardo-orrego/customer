package com.nttdata.customer.api.request;

import com.nttdata.customer.enums.BusinessSubTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessInfoRequest {

    @NotNull(message = "El campo 'subType' no puede ser nulo")
    private BusinessSubTypeEnum subType;

    @NotBlank(message = "El campo 'legalName' no puede estar vacío")
    private String legalName;

    private String tradeName;

    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "El formato de 'incorporationDate' debe ser dd/MM/yyyy")
    private String incorporationDate;

    private String website;

    private String fax;

}
