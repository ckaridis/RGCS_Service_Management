package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.Vehicle;
import com.rgcs_motors.RGCS_Service_Management.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeleteVehicleServiceImpl implements DeleteVehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    private String deletionResultMessage = "";

    @Override
    public String deleteVehicle(Vehicle vehicle) throws Exception {
        try{
            vehicleRepository.delete(vehicle);
            deletionResultMessage = "success";
        }
        catch (Exception e){
            throw new Exception(e.getCause().toString());
        }
        return deletionResultMessage;
    }

}
