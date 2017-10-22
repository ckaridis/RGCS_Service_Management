package com.rgcs_motors.RGCS_Service_Management.converters;

import com.rgcs_motors.RGCS_Service_Management.domain.Repair;
import com.rgcs_motors.RGCS_Service_Management.model.RepairRegistrationForm;

public class RepairConverter {



    public static Repair buildRepairObject(RepairRegistrationForm repairRegistrationForm) {
        Repair repairToBeRegistered = new Repair();
        repairToBeRegistered.setLicenseplate(repairRegistrationForm.getLicenseplates());
        repairToBeRegistered.setRepairCost(repairRegistrationForm.getRepairCost());
        repairToBeRegistered.setRepairType(repairRegistrationForm.getRepairtype());
        repairToBeRegistered.setRepairdate(repairRegistrationForm.getRepairdate());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>"+repairToBeRegistered.getRepairRegistrationDate());
        repairToBeRegistered.setStatus(repairRegistrationForm.getStatus());
        repairToBeRegistered.setRepairDescription(repairRegistrationForm.getRepairDescription());
        return repairToBeRegistered;
    }
}
