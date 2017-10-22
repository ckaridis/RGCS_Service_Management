package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.Vehicle;
import com.rgcs_motors.RGCS_Service_Management.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EditVehicleServiceImpl implements  EditVehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle editVehicle(Vehicle vehicle) throws Exception {
        Vehicle editedVehicle;
        try {
            editedVehicle = vehicleRepository.save(vehicle);
        } catch (Exception e) {
            throw new Exception(e.getCause().toString());
        }
        return editedVehicle;
    }
    
}
