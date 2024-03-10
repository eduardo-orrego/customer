package com.nttdata.customer.api.request;

import com.nttdata.customer.enums.PersonalSubTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfoRequest {

    @NotNull(message = "El campo 'subType' no puede ser nulo")
    private PersonalSubTypeEnum subType;

    @NotBlank(message = "El campo 'fullName' no puede estar vacío")
    private String fullName;

    private String nationality;

    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "El formato de 'incorporationDate' debe ser dd/MM/yyyy")
    private String birthdate;

    private String email;

    private String phoneNumber;

}
