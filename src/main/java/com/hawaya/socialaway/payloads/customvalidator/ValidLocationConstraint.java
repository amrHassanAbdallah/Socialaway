package com.hawaya.socialaway.payloads.customvalidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LocationValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidLocationConstraint {
    String message() default "Invalid location value, location is required and should contain lng, lat in the same order";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}