package com.nttdata.customer.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.customer.enums.PersonalSubTypeEnum;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfoRequest {

    @JsonProperty(value= "subType")
    private PersonalSubTypeEnum subType;

    @JsonProperty(value = "fullName")
    private String fullName;

    @JsonProperty(value = "nationality")
    private String nationality;

    @JsonProperty(value = "birthdate")
    private LocalDate birthdate;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "phoneNumber")
    private String phoneNumber;

}
