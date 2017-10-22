package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.domain.Vehicle;

public interface EditUserService {

    User fetchUserToBeEdited(User user) throws Exception;

    User editUser(User user) throws Exception;

    User editVehicle(Vehicle vehicle) throws Exception;
}
