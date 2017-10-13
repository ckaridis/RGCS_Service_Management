package com.rgcs_motors.RGCS_Service_Management.dao;
import com.rgcs_motors.RGCS_Service_Management.domain.User;

public interface AccountDao {

    User login(String email, String password) throws Exception;

    void logout(String email) throws Exception;
}
