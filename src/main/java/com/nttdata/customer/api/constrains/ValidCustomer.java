package com.nttdata.customer.api.constrains;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomerValidator.class)
public @interface ValidCustomer {
    String message() default "Se detectaron errores en los datos de entrada";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}