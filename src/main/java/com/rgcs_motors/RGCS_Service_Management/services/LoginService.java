package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.User;

import org.springframework.security.core.AuthenticationException;

public interface LoginService {

    User login(String email, String password) throws AuthenticationException;

    void logout(String email) throws Exception;
}
