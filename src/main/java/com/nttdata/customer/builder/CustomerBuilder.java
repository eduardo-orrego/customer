package com.nttdata.customer.builder;

import com.nttdata.customer.api.request.AddressRequest;
import com.nttdata.customer.api.request.BusinessInfoRequest;
import com.nttdata.customer.api.request.CustomerRequest;
import com.nttdata.customer.api.request.IdentificationDocumentRequest;
import com.nttdata.customer.api.request.PersonalInfoRequest;
import com.nttdata.customer.model.Address;
import com.nttdata.customer.model.BusinessInfo;
import com.nttdata.customer.model.Customer;
import com.nttdata.customer.model.IdentificationDocument;
import com.nttdata.customer.model.PersonalInfo;
import java.time.LocalDateTime;
import java.util.Objects;


public class CustomerBuilder {

    CustomerBuilder() {
    }

    public static Customer toEntity(CustomerRequest customerRequest, String customerId) {

        return Customer.builder()
            .id(customerId)
            .type(customerRequest.getType().name())
            .status(customerRequest.getStatus().name())
            .address(Objects.nonNull(customerRequest.getAddress())
                ? toEntity(customerRequest.getAddress())
                : null)
            .identificationDocument(Objects.nonNull(customerRequest.getIdentificationDocument())
                ? toEntity(customerRequest.getIdentificationDocument())
                : null)
            .personalInfo(Objects.nonNull(customerRequest.getPersonalInfo())
                ? toEntity(customerRequest.getPersonalInfo())
                : null)
            .businessInfo(Objects.nonNull(customerRequest.getBusinessInfo())
                ? toEntity(customerRequest.getBusinessInfo())
                : null)
            .dateCreated(LocalDateTime.now())
            .lastUpdated(LocalDateTime.now())
            .build();

    }

    private static Address toEntity(AddressRequest addressRequest) {
        return Address
            .builder()
            .city(addressRequest.getCity())
            .country(addressRequest.getCountry())
            .postalCode(addressRequest.getPostalCode())
            .street(addressRequest.getStreet())
            .build();
    }

    private static IdentificationDocument toEntity(IdentificationDocumentRequest identificationDocumentRequest) {
        return IdentificationDocument
            .builder()
            .type(identificationDocumentRequest.getType().name())
            .number(identificationDocumentRequest.getNumber())
            .build();
    }

    private static PersonalInfo toEntity(PersonalInfoRequest personalInfoRequest) {
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

    private static BusinessInfo toEntity(BusinessInfoRequest businessInfoRequest) {
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
