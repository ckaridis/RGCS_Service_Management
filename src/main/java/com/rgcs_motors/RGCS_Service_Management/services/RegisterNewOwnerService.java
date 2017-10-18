package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.User;

public interface RegisterNewOwnerService {

    String registerNewOwner(User user) throws Exception;
}
