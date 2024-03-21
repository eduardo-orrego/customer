package com.nttdata.customer.api.request;

import com.nttdata.customer.enums.CustomerTypeEnum;
import com.nttdata.customer.enums.StatusTypeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class: CustomerRequest. <br/>
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
public class CustomerRequest {

  @NotNull(message = "El campo 'document' no puede ser nulo")
  private CustomerTypeEnum type;

  @NotNull(message = "El campo 'document' no puede ser nulo")
  private StatusTypeEnum status;

  @NotNull(message = "El campo 'document' no puede ser nulo")
  @Valid
  private DocumentRequest identificationDocument;

  private AddressRequest address;

  @Valid
  private PersonalInfoRequest personalInfo;

  @Valid
  private BusinessInfoRequest businessInfo;

}




