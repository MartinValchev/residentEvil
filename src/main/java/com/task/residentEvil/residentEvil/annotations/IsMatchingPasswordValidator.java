package com.task.residentEvil.residentEvil.annotations;

import com.task.residentEvil.residentEvil.model.RegisterBindingModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsMatchingPasswordValidator implements ConstraintValidator<IsPasswordsMatching,Object> {
    @Override
    public void initialize(IsPasswordsMatching constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object userClass, ConstraintValidatorContext constraintValidatorContext) {
        if(userClass instanceof RegisterBindingModel){
            return ((RegisterBindingModel)userClass).getPassword()
                    .equals( ((RegisterBindingModel)userClass).getConfirmedPassword());
        }
        return false;
    }
}
