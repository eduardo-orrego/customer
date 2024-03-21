package com.nttdata.customer.api.request;

import com.nttdata.customer.enums.PersonalSubTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class: PersonalInfoRequest. <br/>
 * <b>Bootcamp NTTDATA</b><br/>
 *
 * @author NTTDATA
 * @version 1.0
 *   <u>Developed by</u>:
 *   <ul>
 *   <li>Developer Carlos</li>
 *   </ul>
 * @since 1.0
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfoRequest {

  @NotNull(message = "El campo 'personalInfo.subType' no puede ser nulo")
  private PersonalSubTypeEnum subType;

  @NotBlank(message = "El campo 'personalInfo.fullName' no puede estar vacío")
  private String fullName;

  private String nationality;

  private LocalDate birthdate;

  private String email;

  private String phoneNumber;

}
