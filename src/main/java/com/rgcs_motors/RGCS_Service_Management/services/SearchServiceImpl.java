package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.domain.Vehicle;
import com.rgcs_motors.RGCS_Service_Management.repositories.UserRepository;
import com.rgcs_motors.RGCS_Service_Management.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class SearchServiceImpl implements SearchService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public User searchUserByVatAndEmail(String vat, String email) throws Exception {
        User user;
        try {
            user= userRepository.findByEmailAndVat(email,vat);
            if(user == null)
            {
                throw new Exception("User not found!");
            }
        } catch (Exception e) {
            throw new Exception(e.getCause().toString());
        }
        return user;
    }

    @Override
    public User searchUserByVat(String vat) throws Exception {
        User user;
        try {
            user= userRepository.findByVat(vat);
            if(user == null)
            {
                throw new Exception("User not found!");
            }
        } catch (Exception e) {
            throw new Exception(e.getCause().toString());
        }
        return user;
    }

    @Override
    public User searchUserByEmail(String email) throws Exception {
        User user;
        try {
            user= userRepository.findByEmail(email);
            if(user == null)
            {
                throw new Exception("User not found!");
            }
        } catch (Exception e) {
            throw new Exception(e.getCause().toString());
        }
        return user;
    }

    @Override
    public List<Vehicle> searchVehicleByVatAndPlate(String uservatvat, String licenseplate) throws Exception {
        List<Vehicle> vehicles;
        try {
            vehicles = vehicleRepository.findByLicenseplateAndUservat(licenseplate,uservatvat);
            if(vehicles.isEmpty())
            {
                throw new Exception("Vehicle not found!");
            }
        } catch (Exception e) {
            throw new Exception(e.getCause().toString());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> searchVehicleByVat(String uservat) throws Exception {
        List<Vehicle> vehicles;
        try {
            vehicles = vehicleRepository.findByUservat(uservat);
            if(vehicles.isEmpty())
            {
                throw new Exception("Vehicles not found!");
            }
        } catch (Exception e) {
            throw new Exception(e.getCause().toString());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> searchVehicleByPlate(String licenseplate) throws Exception {
        List<Vehicle> vehicles;
        try {
            vehicles = vehicleRepository.findByLicenseplate(licenseplate);
            if(vehicles.isEmpty())
            {
                throw new Exception("Vehicle not found!");
            }
        } catch (Exception e) {
            throw new Exception(e.getCause().toString());
        }
        return vehicles;
    }
}
