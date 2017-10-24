package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeleteUserServiceImpl implements DeleteUserService{

    @Autowired
    private UserRepository userRepository;

    private String deletionResultMessage = "";

    @Override
    public String deleteUser(User user) throws Exception {
        try{
            userRepository.delete(user);
            deletionResultMessage = "success";
        }
        catch (Exception e){
            throw new Exception(e.getCause().toString());
        }
        return deletionResultMessage;
    }

}
