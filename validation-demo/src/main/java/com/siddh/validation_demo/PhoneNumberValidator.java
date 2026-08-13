package com.siddh.validation_demo;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

//PhoneNumber → annotation being handled
//String → type of value being validated
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber,String> {

    private static final String PHONE_PATTERN="^(\\+91[\\-\\s]?)?[6-9][0-9]{9}$";

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        if(phoneNumber==null || phoneNumber.isBlank()){
            return false;
        }

        return phoneNumber.matches(PHONE_PATTERN);
    }
}
