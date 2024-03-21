package com.nttdata.customer.api.request;

import com.nttdata.customer.enums.BusinessSubTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class: BusinessInfoRequest. <br/>
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
