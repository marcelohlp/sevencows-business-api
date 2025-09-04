package com.sevencows.business.model.enums.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class EnumValidator implements ConstraintValidator<ValidEnum, String> {

    private List<String> acceptedValues;

    @Override
    public void initialize(ValidEnum validEnum) {

        acceptedValues = Arrays.stream(validEnum.enumClass().getEnumConstants())
                .map(Enum::name)
                .toList();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value != null && acceptedValues.contains(value);
    }
}
