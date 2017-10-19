package com.rgcs_motors.RGCS_Service_Management.validators;

import com.rgcs_motors.RGCS_Service_Management.model.OwnerRegistrationForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class OwnerRegistrationFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return OwnerRegistrationForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        OwnerRegistrationForm form = (OwnerRegistrationForm) o;
        if(form.getPassword() != form.getConfirmpassword())
        {
            errors.rejectValue("confirmpassword","Confirm Password doesn't match password");
        }
        if(form.getType() != "Admin" || form.getType() != "Owner")
        {
            errors.rejectValue("type","User type must either be 'Admin' or 'Owner'");
        }
    }
}
