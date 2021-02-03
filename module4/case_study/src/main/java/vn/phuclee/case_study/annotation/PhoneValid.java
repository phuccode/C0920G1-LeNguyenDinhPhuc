package vn.phuclee.case_study.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValid implements ConstraintValidator<Phone, String> {
    private static final String PHONE_PREFIX = "090";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) return false;

        return value.startsWith(PHONE_PREFIX);
    }
}
