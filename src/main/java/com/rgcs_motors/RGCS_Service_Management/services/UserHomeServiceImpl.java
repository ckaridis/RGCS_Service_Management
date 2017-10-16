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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<Service> fetchServicesForUser(String username) {
        User user = userRepository.findByEmail(username);
        List<Vehicle> vehicles = vehicleRepository.findByUser_vat(user.getVat());
        List<Service> services = new ArrayList<>();
        for(Vehicle v: vehicles)
        {
            services.add(serviceRepository.findByVEHICLE_PLATE(v.getLicensePlates()));
        }
        return services;
    }
}
