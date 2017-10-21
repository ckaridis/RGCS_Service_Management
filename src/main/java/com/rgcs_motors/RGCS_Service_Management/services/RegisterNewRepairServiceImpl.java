package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.Repair;
import com.rgcs_motors.RGCS_Service_Management.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RegisterNewRepairServiceImpl implements RegisterNewRepairService {

    private final String errorMessage = "Repair Registration could not be completed";
    private final String successMessage = "Success in registering new repair";
    private String returnedMessage = "";

    @Autowired
    private RepairRepository repairRepo;

    @Override
    public String registerNewRepair(Repair repair) throws Exception {
        Repair registeredRepair;
        try {
            registeredRepair = repairRepo.save(repair);
            returnedMessage = (registeredRepair == null) ? errorMessage : successMessage;
        }
        /*catch (MySQ e){
            throw new Exception("The User with the above VAT does not exist");

        }*/
        catch(Exception e) {
            throw new Exception(e.getMessage().toString());
        }
        return returnedMessage;    }
}
