package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterNewOwnerImpl implements RegisterNewOwnerService {

    private final String errorMessage = "Registration could not be completed";
    private final String successMesage = "success";
    private String returnedMessage = "";

    @Autowired
    private UserRepository userRepo;

    @Override
    public String registerNewOwner(User user) throws Exception{
        User registeredUser;
        try{
           registeredUser = userRepo.save(user);
           returnedMessage = (registeredUser == null) ? errorMessage : successMesage;
        }
        catch(Exception e)
        {
            throw new Exception(e.getMessage().toString());
        }

        return returnedMessage;
    }

}
