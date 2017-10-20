package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.Vehicle;

public interface RegisterNewVehicleService {

    String registerNewVehicle(Vehicle vehicle) throws Exception;

}
