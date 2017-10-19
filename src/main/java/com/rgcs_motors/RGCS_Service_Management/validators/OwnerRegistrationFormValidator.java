package com.rgcs_motors.RGCS_Service_Management.validators;

import com.rgcs_motors.RGCS_Service_Management.model.OwnerRegistrationForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class OwnerRegistrationFormValidator implements Validator {

    private final static String adminType = "Admin";
    private final static String ownerType = "Owner";

    @Override
    public boolean supports(Class<?> aClass) {
        return OwnerRegistrationForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        OwnerRegistrationForm form = (OwnerRegistrationForm) o;
        if(!form.getPassword().equals(form.getConfirmpassword()))
        {
            System.out.println(">>>>>>>>>>>>>>>>Validator pass error");
            errors.rejectValue("confirmpassword","Confirm Password doesn't match password");
        }
        if(!form.getType().toString().trim().equals(adminType) ||
                !form.getType().toString().trim().equals(ownerType))
        {
            System.out.println(form.getType().trim());
            System.out.println(">>>>>>>>>>>>>>>>Validator type error");
            errors.rejectValue("type","User type must either be 'Admin' or 'Owner'");
        }
    }
}
