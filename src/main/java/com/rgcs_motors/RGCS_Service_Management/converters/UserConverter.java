package com.rgcs_motors.RGCS_Service_Management.converters;


import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.model.OwnerRegistrationForm;

public class UserConverter {

    public static User buildUserObject(OwnerRegistrationForm registrationForm) {
        User userToBeRegistered = new User();
        userToBeRegistered.setFirstName(registrationForm.getFirstname());
        userToBeRegistered.setLastName(registrationForm.getLastname());
        userToBeRegistered.setPassword(registrationForm.getPassword());
        userToBeRegistered.setEmail(registrationForm.getEmail());
        userToBeRegistered.setAddress(registrationForm.getAddress());
        userToBeRegistered.setVat(registrationForm.getVat());
        userToBeRegistered.setType(registrationForm.getType());
        return userToBeRegistered;
    }
}
