package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.dao.AccountDao;
import com.rgcs_motors.RGCS_Service_Management.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public User login(String email, String password) {
        User user = null;
        try {
            user = accountDao.login(email, password);
        } catch (Exception e) {
//            throw new InvalidCredentialsException("User not found!");
            e.printStackTrace ();
        }
        return user;
    }

    @Override
    public void logout(String email) {
        try {
            accountDao.logout(email);
        } catch (Exception e) {
//            throw new LogoutException("User not logged in!");
            e.printStackTrace ();
        }
    }
}
