package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.Service;

import java.util.List;

public interface UserHomeService {

    List<Service> fetchServicesForUser(String username);
}
