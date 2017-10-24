package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.Repair;
import com.rgcs_motors.RGCS_Service_Management.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeleteRepairServiceImpl implements DeleteRepairService{

    @Autowired
    private RepairRepository repairRepository;

    private String deletionResultMessage = "";

    @Override
    public String deleteRepair(Repair repair) throws Exception {
        try{
            repairRepository.delete(repair);
            deletionResultMessage = "success";
        }
        catch (Exception e){
            throw new Exception(e.getCause().toString());
        }
        return deletionResultMessage;
    }

}
