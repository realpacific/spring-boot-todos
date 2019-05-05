package com.realpacific.springboottodos.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UsernameValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface IsValidUsername {
    String message() default "Failed to valid username.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
