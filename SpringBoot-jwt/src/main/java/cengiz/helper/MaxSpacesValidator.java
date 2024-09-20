package cengiz.helper;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

public class MaxSpacesValidator implements ConstraintValidator<MaxSpaces, String> {

    private int maxSpaces;

    @Override
    public void initialize(MaxSpaces constraintAnnotation) {
        this.maxSpaces = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        long spaceCount = value.chars()
                .filter(ch -> ch == ' ')
                .count();

        return spaceCount <= maxSpaces;
    }
}

