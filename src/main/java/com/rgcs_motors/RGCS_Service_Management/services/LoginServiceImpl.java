package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void login(String username, String password) {

        try {
            accountDao.login(username, password);
        } catch (Exception e) {
//            throw new InvalidCredentialsException("User not found!");
            e.printStackTrace ();
        }
    }

    @Override
    public void logout(String username) {
        try {
            accountDao.logout(username);
        } catch (Exception e) {
//            throw new LogoutException("User not logged in!");
            e.printStackTrace ();
        }
    }
}
