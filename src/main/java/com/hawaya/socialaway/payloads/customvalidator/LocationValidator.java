package com.hawaya.socialaway.payloads.customvalidator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;




public class LocationValidator implements ConstraintValidator<ValidLocationConstraint,Float[]> {

    @Override
    public boolean isValid(Float[] location,
                           ConstraintValidatorContext cxt) {
        return location!=null && location.length==2;
    }
}
