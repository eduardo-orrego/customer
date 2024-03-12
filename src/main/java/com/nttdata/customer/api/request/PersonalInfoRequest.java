package com.nttdata.customer.api.request;

import com.nttdata.customer.enums.PersonalSubTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
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

    private LocalDate birthdate;

    private String email;

    private String phoneNumber;

}
