package com.rgcs_motors.RGCS_Service_Management.converters;


import com.rgcs_motors.RGCS_Service_Management.domain.Vehicle;
import com.rgcs_motors.RGCS_Service_Management.model.VehicleData;

public class VehicleFromJsoConverter {

    public static Vehicle buildVehicleObjectFromJson(VehicleData vehicleData) {
        Vehicle vehicleToBeDeleted = new Vehicle();
        vehicleToBeDeleted.setBrand(vehicleData.getBrand());
        vehicleToBeDeleted.setModel(vehicleData.getModel());
        vehicleToBeDeleted.setLicenseplate(vehicleData.getLicenseplates());
        vehicleToBeDeleted.setFactoryDate(vehicleData.getFactorydate());
        vehicleToBeDeleted.setColour(vehicleData.getColour());
        vehicleToBeDeleted.setUservat(vehicleData.getUservat());
        vehicleToBeDeleted.setId(vehicleData.getId());
        return vehicleToBeDeleted;
    }

}
