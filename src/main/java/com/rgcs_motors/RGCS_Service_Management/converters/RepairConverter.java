package com.rgcs_motors.RGCS_Service_Management.converters;

import com.rgcs_motors.RGCS_Service_Management.domain.Repair;
import com.rgcs_motors.RGCS_Service_Management.model.RepairRegistrationForm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class RepairConverter {



    public static Repair buildRepairObject(RepairRegistrationForm repairRegistrationForm) throws ParseException {
        Repair repairToBeRegistered = new Repair();

        StringBuilder dateWithoutT = new StringBuilder(repairRegistrationForm.getRepairdate());
        dateWithoutT.setCharAt(10, ' ');

        repairToBeRegistered.setRepairdate(dateWithoutT.toString());
        repairToBeRegistered.setLicenseplate(repairRegistrationForm.getLicenseplates());
        repairToBeRegistered.setRepairCost(repairRegistrationForm.getRepairCost());
        repairToBeRegistered.setRepairType(repairRegistrationForm.getRepairtype());
        repairToBeRegistered.setStatus(repairRegistrationForm.getStatus());
        repairToBeRegistered.setRepairDescription(repairRegistrationForm.getRepairDescription());
        return repairToBeRegistered;
    }
}
