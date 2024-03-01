package com.nttdata.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfo {

    @JsonProperty(value = "full_name")
    @Field(value = "full_name")
    private String fullName;

    @JsonProperty(value = "nationality")
    @Field(value = "nationality")
    private String nationality;

    @JsonProperty(value = "birthdate")
    @Field(value = "birthdate")
    private LocalDate birthdate;

    @JsonProperty(value = "email")
    @Field(value = "email")
    private String email;

    @JsonProperty(value = "phone_number_personal")
    @Field(value = "phone_number_personal")
    private String phoneNumberPersonal;

    @JsonProperty(value = "phone_number_work")
    @Field(value = "phone_number_work")
    private String phoneNumberWork;

}
