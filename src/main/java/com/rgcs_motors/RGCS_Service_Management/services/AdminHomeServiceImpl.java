package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.Repair;
import com.rgcs_motors.RGCS_Service_Management.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdminHomeServiceImpl implements AdminHomeService {

    @Autowired
    private RepairRepository repairRepository;

    private final String repairsAdminNotFoundError = "No pending Admin repairs found";



    @Override
    public List<Repair> fetchRepairsForAdmin() throws Exception {

        List<Repair> repairs = new ArrayList<>();
        String errorMessage = "";

        try {
            repairs = repairRepository.findTop10ByStatusOrderByRepairdateAsc("InProgress");
        }
        catch(Exception e) {
            errorMessage = e.getMessage().toString();
        }
        if(repairs.isEmpty()){
            errorMessage = repairsAdminNotFoundError;
            System.out.println("Repairs Admin is empty !\n");
        }
        else {
            for (Repair repair : repairs) {
                System.out.println(">>>>>>>>>>>>>>>>>>the Admin repairs date " + repair.getRepairdate());
            }
        }
        if(errorMessage != ("")) {
            throw new Exception(errorMessage);
        }

        return repairs;
    }
}
