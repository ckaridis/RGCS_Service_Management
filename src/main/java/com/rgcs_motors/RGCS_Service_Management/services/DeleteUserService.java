package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.User;

public interface DeleteUserService {

    String deleteUser(User user) throws Exception;
}
