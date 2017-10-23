package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.Repair;

public interface DeleteRepairService {

    String deleteRepair(Repair repair) throws Exception;
}
