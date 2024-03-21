package com.nttdata.customer.api.request;

import com.nttdata.customer.enums.DocumentTypeEnum;
import jakarta.validation.constraints.NotNull;
import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class: DocumentRequest. <br/>
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
public class DocumentRequest {

  @NotNull(message = "El campo 'document.type' no puede ser nulo")
  private DocumentTypeEnum type;

  @NotNull(message = "El campo 'document.number' no puede ser nulo")
  private BigInteger number;
}
