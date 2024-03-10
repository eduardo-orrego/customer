package com.nttdata.customer.api.constrains;

import com.nttdata.customer.api.request.IdentificationDocumentRequest;
import com.nttdata.customer.enums.DocumentTypeEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdentificationDocumentValidator implements ConstraintValidator<ValidIdentificationDocument, IdentificationDocumentRequest> {

    @Override
    public void initialize(ValidIdentificationDocument constraintAnnotation) {
    }

    @Override
    public boolean isValid(IdentificationDocumentRequest value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        if (value.getType() == DocumentTypeEnum.DNI) {

            if (value.getNumber() == null || value.getNumber().length() != 8) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                    "El campo 'number' debe tener 8 dígitos cuando el campo 'identificationDocument.type' tiene " +
                        "valor DNI").addConstraintViolation();
                return false;
            }
        } else if (value.getType() == DocumentTypeEnum.RUC) {
            if (value.getNumber() == null || value.getNumber().length() != 11) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                    "El campo 'number' debe tener 11 dígitos cuando el campo'identificationDocument.type' tiene " +
                        "valor RUC").addConstraintViolation();
                return false;
            }
        }

        return true;
    }
}