package com.rgcs_motors.RGCS_Service_Management.services;

import javax.naming.AuthenticationException;

public interface LoginService {

    void login(String username, String password);

    void logout(String username) throws Exception;
}
