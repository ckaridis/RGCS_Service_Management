package com.rgcs_motors.RGCS_Service_Management.dao;

import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

    @Autowired
    UserRepository userRepo;

    @Override
    public User login ( String email, String password ) throws Exception {
        User user = userRepo.findByEmailAndPassword ( email, password );
        return user;
    }

    @Override
    public void logout ( String email ) throws Exception {

    }
}
