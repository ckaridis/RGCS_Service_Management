package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.User;

import javax.naming.AuthenticationException;

public interface LoginService {

    User login(String email, String password);

    void logout(String email) throws Exception;
}
