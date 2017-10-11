package com.rgcs_motors.RGCS_Service_Management.dao;
import com.rgcs_motors.RGCS_Service_Management.domain.Users;

public interface AccountDao {

    Users login(String username, String password) throws Exception;

    void logout(String username) throws Exception;
}
