package com.siddh.validation_demo;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)  //It tells Jakarta Validation: @PhoneNumber is a validation constraint, and PhoneNumberValidator contains the validation logic.
public @interface PhoneNumber {
    String message() default "Invalid Phone number";
    //Validation groups let you apply different validations in different situations.
    //For example, maybe a field is required when creating a user but not when updating one.
    Class<?>[] groups() default {};

    //payload() allows custom metadata to be associated with a validation constraint.
    Class<? extends Payload>[] payload() default {};

}
