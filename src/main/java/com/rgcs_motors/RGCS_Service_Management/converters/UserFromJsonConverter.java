package com.rgcs_motors.RGCS_Service_Management.converters;

import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.model.UserData;

public class UserFromJsonConverter {

    public static User buildUserObjectFromJson(UserData userData) {
        User userToBeDeleted = new User();
        userToBeDeleted.setType(userData.getType());
        userToBeDeleted.setVat(userData.getVat());
        userToBeDeleted.setAddress(userData.getAddress());
        userToBeDeleted.setFirstName(userData.getFirstname());
        userToBeDeleted.setLastName(userData.getLastname());
        userToBeDeleted.setEmail(userData.getEmail());
        userToBeDeleted.setPassword(userData.getPassword());
        userToBeDeleted.setId(userData.getId());
        return userToBeDeleted;
    }
}
