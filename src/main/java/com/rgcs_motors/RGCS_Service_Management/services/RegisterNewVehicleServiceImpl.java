package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.Vehicle;
import com.rgcs_motors.RGCS_Service_Management.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RegisterNewVehicleServiceImpl implements RegisterNewVehicleService {

    private final String errorMessage = "Vehicle Registration could not be completed";
    private final String successMessage = "Success in registering new vehicle";
    private String returnedMessage = "";

    @Autowired
    private VehicleRepository vehicleRepo;

    @Override
    public String registerNewVehicle(Vehicle vehicle) throws Exception {

        Vehicle registeredVehicle;
        try {

            registeredVehicle = vehicleRepo.save(vehicle);
            returnedMessage = (registeredVehicle == null) ? errorMessage : successMessage;
        }
        catch(Exception e) {
            throw new Exception(e.getMessage().toString());
        }
        return returnedMessage;
    }
}
