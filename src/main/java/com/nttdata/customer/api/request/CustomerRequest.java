package com.nttdata.customer.api.request;

import com.nttdata.customer.api.constrains.ValidCustomer;
import com.nttdata.customer.enums.CustomerTypeEnum;
import com.nttdata.customer.enums.StatusTypeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ValidCustomer
public class CustomerRequest {

    @NotNull(message = "El campo 'identificationDocument' no puede ser nulo")
    private CustomerTypeEnum type;

    @NotNull(message = "El campo 'identificationDocument' no puede ser nulo")
    private StatusTypeEnum status;

    @NotNull(message = "El campo 'identificationDocument' no puede ser nulo")
    @Valid
    private IdentificationDocumentRequest identificationDocument;

    private AddressRequest address;

    @Valid
    private PersonalInfoRequest personalInfo;

    @Valid
    private BusinessInfoRequest businessInfo;

}




