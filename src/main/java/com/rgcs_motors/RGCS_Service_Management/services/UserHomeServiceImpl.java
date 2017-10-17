package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.Service;
import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.domain.Vehicle;
import com.rgcs_motors.RGCS_Service_Management.repositories.ServiceRepository;
import com.rgcs_motors.RGCS_Service_Management.repositories.UserRepository;
import com.rgcs_motors.RGCS_Service_Management.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class UserHomeServiceImpl implements UserHomeService {

    private final String repairsNotFoundError = "No pending repairs found";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<Service> fetchServicesForUser(String username) throws Exception{
        User user;
        List<Vehicle> vehicles = new ArrayList<>();
        String errorMessage = "";
        try{
          user = userRepository.findByEmail(username);
          vehicles = vehicleRepository.findByUservat(user.getVat());
        }
        catch(Exception e)
        {
            errorMessage = e.getMessage().toString();
        }

        List<Service> services = new ArrayList<>();
        for(Vehicle v: vehicles)
        {
            services.add(serviceRepository.findByLicenseplate(v.getLicensePlates()));
            System.out.println(services.toString());
        }
        if(services.isEmpty())
        {
            errorMessage = repairsNotFoundError;
        }

        if(errorMessage != null)
        {
            throw new Exception(errorMessage);
        }
        return services;
    }
}
