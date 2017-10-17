package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.Repair;

import java.util.List;

public interface UserHomeService {

    List<Repair> fetchServicesForUser(String username) throws Exception;
}
