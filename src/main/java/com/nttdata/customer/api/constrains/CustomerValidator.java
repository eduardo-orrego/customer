package com.nttdata.customer.api.constrains;

import com.nttdata.customer.api.request.CustomerRequest;
import com.nttdata.customer.enums.CustomerTypeEnum;
import com.nttdata.customer.enums.DocumentTypeEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomerValidator implements ConstraintValidator<ValidCustomer, CustomerRequest> {

    @Override
    public void initialize(ValidCustomer constraintAnnotation) {
    }

    @Override
    public boolean isValid(CustomerRequest customerRequest, ConstraintValidatorContext constraintValidatorContext) {
        if (customerRequest.getType() == CustomerTypeEnum.PERSONAL) {
            if (customerRequest.getPersonalInfo() == null) {
                constraintValidatorContext.buildConstraintViolationWithTemplate(
                        "El campo 'personalInfo' no puede ser nulo cuando el campo type tiene valor 'PERSONAL")
                    .addConstraintViolation();
                return false;
            }

            if (customerRequest.getIdentificationDocument().getType() != null
                && customerRequest.getIdentificationDocument().getType() != DocumentTypeEnum.DNI) {
                constraintValidatorContext.buildConstraintViolationWithTemplate(
                        "El campo 'identificationNumber.type' no puede tener un valor distinto a 'DNI' " +
                            " cuando el campo type tiene valor 'PERSONAL")
                    .addConstraintViolation();
                return false;
            }
        }

        if (customerRequest.getType() == CustomerTypeEnum.BUSINESS) {
            if (customerRequest.getBusinessInfo() == null) {
                constraintValidatorContext.buildConstraintViolationWithTemplate(
                        "El campo 'businessInfo' no puede ser nulo cuando el campo type tiene valor 'BUSINESS")
                    .addConstraintViolation();
                return false;
            }

            if (customerRequest.getIdentificationDocument().getType() != null
                && customerRequest.getIdentificationDocument().getType() != DocumentTypeEnum.RUC) {
                constraintValidatorContext.buildConstraintViolationWithTemplate(
                        "El campo 'identificationNumber.type' no puede tener un valor distinto a 'RUC' " +
                            " cuando el campo type tiene valor 'PERSONAL")
                    .addConstraintViolation();
                return false;
            }
        }

        return true;
    }
}