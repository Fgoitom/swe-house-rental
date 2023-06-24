package miu.edu.model.constraints.Validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import miu.edu.model.constraints.PositiveNumberConstraint;

public class PositiveNumberValidator implements ConstraintValidator<PositiveNumberConstraint, Number> {

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        return value != null && value.doubleValue() > 0;
    }
    
}
