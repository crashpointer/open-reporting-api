package org.crash.reporting.api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValueValidator implements ConstraintValidator<Enum, String> {

    private Enum annotation;

    @Override
    public void initialize(Enum constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String validation, ConstraintValidatorContext constraintValidatorContext) {
        Object[] enumValues = annotation.enumClass().getEnumConstants();
        if (enumValues != null) {
            for (Object enumValue : enumValues) {
                if (validation.equals(enumValue.toString()) ||
                        (annotation.ignoreCase() && validation.equalsIgnoreCase(enumValue.toString()))) {
                    return true;
                }
            }
        }

        return false;
    }
}
