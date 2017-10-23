package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.domain.Vehicle;
import com.rgcs_motors.RGCS_Service_Management.repositories.UserRepository;
import com.rgcs_motors.RGCS_Service_Management.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EditUserServiceImpl implements EditUserService{

    @Autowired
    private UserRepository userRepository;

    private User returnedUser;

    @Override
    public User fetchUserToBeEdited(User user) throws Exception {
        try {
            returnedUser = userRepository.findById(user.getId());
        } catch (Exception e) {
            throw new Exception(e.getCause().toString());
        }
        return returnedUser;
    }

    @Override
    public User editUser(User user) throws Exception {
        User editedUser = null;
        try {
                editedUser = userRepository.save(user);
            } catch (Exception e) {
                throw new Exception(e.getCause().toString());
            }
        return editedUser;
        }




    @Override
    public User editVehicle(Vehicle vehicle) throws Exception {
        return null;
    }
}
