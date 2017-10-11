package com.rgcs_motors.RGCS_Service_Management.dao;

import com.rgcs_motors.RGCS_Service_Management.domain.Users;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

    @Override
    public Users login ( String username, String password ) throws Exception {
        return null;
    }

    @Override
    public void logout ( String username ) throws Exception {

    }
}
