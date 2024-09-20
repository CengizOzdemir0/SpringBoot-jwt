package cengiz.helper;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@Constraint(validatedBy = AlphabeticValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Alphabetic {
    String message() default "Yalnızca harflerden oluşmalıdır";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
