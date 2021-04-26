package com.hawaya.socialaway.payloads.customvalidator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.util.List;


public class LocationValidator implements ConstraintValidator<ValidLocationConstraint, List<Double>> {

    @Override
    public boolean isValid(List<Double> location,
                           ConstraintValidatorContext cxt) {
        return location!=null && location.size()==2;
    }
}
