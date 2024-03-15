package com.nttdata.customer.api.request;

import com.nttdata.customer.enums.BusinessSubTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessInfoRequest {

    @NotNull(message = "El campo 'businessInfo.subType' no puede ser nulo")
    private BusinessSubTypeEnum subType;

    @NotBlank(message = "El campo 'businessInfo.legalName' no puede estar vacío")
    private String legalName;

    private String tradeName;

    private LocalDate incorporationDate;

    private String website;

    private String fax;

}
