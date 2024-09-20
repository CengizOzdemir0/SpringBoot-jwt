package cengiz.helper;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

public class AlphabeticValidator implements ConstraintValidator<Alphabetic, String> {

    @Override
    public void initialize(Alphabetic constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ]+");
    }
}
