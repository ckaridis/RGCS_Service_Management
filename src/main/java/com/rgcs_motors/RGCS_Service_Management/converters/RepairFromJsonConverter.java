package com.rgcs_motors.RGCS_Service_Management.converters;

import com.rgcs_motors.RGCS_Service_Management.domain.Repair;
import com.rgcs_motors.RGCS_Service_Management.model.RepairData;

public class RepairFromJsonConverter {

    public static Repair buildRepairObjectFromJson(RepairData repairData){
        Repair repairToBeDeleted = new Repair();
        repairToBeDeleted.setId(repairData.getId());
        repairToBeDeleted.setLicenseplate(repairData.getLicenseplates());
        repairToBeDeleted.setRepairCost(repairData.getRepaircost());
        repairToBeDeleted.setRepairdate(repairData.getRepairDate());
        repairToBeDeleted.setRepairDescription(repairData.getDescription());
        repairToBeDeleted.setRepairType(repairData.getRepairtype());
        repairToBeDeleted.setStatus(repairData.getStatus());
        return repairToBeDeleted;
    }
}
