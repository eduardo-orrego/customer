package com.nttdata.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfo {

    @JsonProperty(value = "full_name")
    private String fullName;

    @JsonProperty(value = "nationality")
    private String nationality;

    @JsonProperty(value = "birthdate")
    private LocalDate birthdate;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "phone_number_personal")
    private String phoneNumberPersonal;

    @JsonProperty(value = "phone_number_work")
    private String phoneNumberWork;

}
