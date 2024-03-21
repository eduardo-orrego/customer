package com.nttdata.customer.builder;

import com.nttdata.customer.api.request.AddressRequest;
import com.nttdata.customer.api.request.BusinessInfoRequest;
import com.nttdata.customer.api.request.CustomerRequest;
import com.nttdata.customer.api.request.DocumentRequest;
import com.nttdata.customer.api.request.PersonalInfoRequest;
import com.nttdata.customer.model.Address;
import com.nttdata.customer.model.BusinessInfo;
import com.nttdata.customer.model.Customer;
import com.nttdata.customer.model.IdentificationDocument;
import com.nttdata.customer.model.PersonalInfo;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class: CustomerBuilder. <br/>
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
public class CustomerBuilder {

  CustomerBuilder() {
  }

  public static Customer toEntity(CustomerRequest customerRequest) {

    return Customer.builder()
      .type(customerRequest.getType().name())
      .status(customerRequest.getStatus().name())
      .identificationDocument(toDocumentEntity(customerRequest.getIdentificationDocument()))
      .address(Objects.nonNull(customerRequest.getAddress())
        ? toAddressEntity(customerRequest.getAddress())
        : null)
      .personalInfo(Objects.nonNull(customerRequest.getPersonalInfo())
        ? toPersonalInfoEntity(customerRequest.getPersonalInfo())
        : null)
      .businessInfo(Objects.nonNull(customerRequest.getBusinessInfo())
        ? toBusinessInfoEntity(customerRequest.getBusinessInfo())
        : null)
      .dateCreated(LocalDateTime.now())
      .lastUpdated(LocalDateTime.now())
      .build();

  }

  public static Customer toEntity(CustomerRequest customerRequest, Customer customer) {

    return Customer.builder()
      .id(customer.getId())
      .type(customerRequest.getType().name())
      .status(customerRequest.getStatus().name())
      .identificationDocument(toDocumentEntity(customerRequest.getIdentificationDocument()))
      .address(Objects.nonNull(customerRequest.getAddress())
        ? toAddressEntity(customerRequest.getAddress())
        : customer.getAddress())
      .personalInfo(Objects.nonNull(customerRequest.getPersonalInfo())
        ? toPersonalInfoEntity(customerRequest.getPersonalInfo())
        : customer.getPersonalInfo())
      .businessInfo(Objects.nonNull(customerRequest.getBusinessInfo())
        ? toBusinessInfoEntity(customerRequest.getBusinessInfo())
        : customer.getBusinessInfo())
      .dateCreated(customer.getDateCreated())
      .lastUpdated(LocalDateTime.now())
      .build();

  }

  private static Address toAddressEntity(AddressRequest addressRequest) {
    return Address
      .builder()
      .city(addressRequest.getCity())
      .country(addressRequest.getCountry())
      .postalCode(addressRequest.getPostalCode())
      .street(addressRequest.getStreet())
      .build();
  }

  private static IdentificationDocument toDocumentEntity(DocumentRequest documentRequest) {
    return IdentificationDocument
      .builder()
      .type(documentRequest.getType().name())
      .number(documentRequest.getNumber())
      .build();
  }

  private static PersonalInfo toPersonalInfoEntity(PersonalInfoRequest personalInfoRequest) {
    return PersonalInfo
      .builder()
      .subType(personalInfoRequest.getSubType().name())
      .email(personalInfoRequest.getEmail())
      .birthdate(personalInfoRequest.getBirthdate())
      .fullName(personalInfoRequest.getFullName())
      .nationality(personalInfoRequest.getNationality())
      .phoneNumber(personalInfoRequest.getPhoneNumber())
      .build();
  }

  private static BusinessInfo toBusinessInfoEntity(BusinessInfoRequest businessInfoRequest) {
    return BusinessInfo
      .builder()
      .subType(businessInfoRequest.getSubType().name())
      .legalName(businessInfoRequest.getLegalName())
      .tradeName(businessInfoRequest.getTradeName())
      .incorporationDate(businessInfoRequest.getIncorporationDate())
      .website(businessInfoRequest.getWebsite())
      .fax(businessInfoRequest.getFax())
      .build();
  }

}
