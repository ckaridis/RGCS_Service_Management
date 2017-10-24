package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.Repair;
import com.rgcs_motors.RGCS_Service_Management.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EditRepairServiceImpl implements EditRepairService {

    @Autowired
    private RepairRepository repairRepository;

    @Override
    public Repair editRepair(Repair repair) throws Exception {
        Repair editedRepair;
        try {
            editedRepair = repairRepository.save(repair);
        } catch (Exception e) {
            throw new Exception(e.getCause().toString());
        }
        return editedRepair;
    }

}
