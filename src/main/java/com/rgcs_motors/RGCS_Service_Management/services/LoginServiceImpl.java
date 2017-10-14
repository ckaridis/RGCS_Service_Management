package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.exceptions.InvalidCredentialsException;
import com.rgcs_motors.RGCS_Service_Management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String email, String password) throws AuthenticationException{
        User user = null;
        try {
            user = userRepository.findByEmailAndPassword(email, password);
        } catch (Exception e) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>service sout: user not found");
            throw new InvalidCredentialsException("User not found!");
        }
        return user;
    }

    @Override
    public void logout(String email) {
        try {
            //userRepository.findByEmailAndPassword(email);
        } catch (Exception e) {
//            throw new LogoutException("User not logged in!");
            e.printStackTrace ();
        }
    }
}
