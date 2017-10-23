package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.Vehicle;

public interface DeleteVehicleService {

    String deleteVehicle(Vehicle vehicle) throws Exception;
}
