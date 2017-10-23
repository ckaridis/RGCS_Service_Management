package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.Repair;
import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.domain.Vehicle;
import com.rgcs_motors.RGCS_Service_Management.repositories.RepairRepository;
import com.rgcs_motors.RGCS_Service_Management.repositories.UserRepository;
import com.rgcs_motors.RGCS_Service_Management.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserHomeServiceImpl implements UserHomeService {

    private final String repairsNotFoundError = "No pending repairs found";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private RepairRepository repairRepository;

    @Override
    public List<Repair> fetchServicesForUser(String username) throws Exception{
        User user;
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        String errorMessage = "";
        try{
          user = userRepository.findByEmail(username);
            System.out.println("user vat : " + user.getVat());
          vehicles = vehicleRepository.findByUservat(user.getVat());
            System.out.println("plate : " + vehicles.get(0).getLicensePlate());
        }
        catch(Exception e)
        {
            errorMessage = e.getMessage().toString();
        }

        List<Repair> repairs = new ArrayList<Repair>();
        List<Repair> repairsPerVehicle  = new ArrayList<Repair>();

        for(Vehicle v: vehicles)
        {
            repairsPerVehicle = repairRepository.findByLicenseplate(v.getLicensePlate());
            for(Repair repair : repairsPerVehicle)
            {
                repairs.add(repair);
                System.out.println(repair.getRepairDescription());
            }
        }
        if(repairs.isEmpty())
        {
            errorMessage = repairsNotFoundError;
            System.out.println("service is empty !\n");
        }

        if(errorMessage != "")
        {
            throw new Exception(errorMessage);
        }
        return repairs;
    }
}
