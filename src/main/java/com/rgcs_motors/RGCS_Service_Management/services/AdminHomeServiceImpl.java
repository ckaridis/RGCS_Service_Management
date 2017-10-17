package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.Repair;
import com.rgcs_motors.RGCS_Service_Management.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminHomeServiceImpl implements AdminHomeService {

    @Autowired
    private RepairRepository repairRepository;


    @Override
    public List<Repair> fetchRepairsForOwner() {

        List<Repair> repairs;

        repairs = repairRepository.findTop10ByOrderByRepairdateAsc();

        for (int i = 0; i < repairs.size(); i++) {
            System.out.println(">>>>>>>>>>>>>>>>>>the Admin repairs  " +repairs.get(i).getRepairdate());
        }


        return repairs;
    }
}
