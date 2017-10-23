package com.rgcs_motors.RGCS_Service_Management.converters;

import com.rgcs_motors.RGCS_Service_Management.domain.Vehicle;
import com.rgcs_motors.RGCS_Service_Management.model.VehicleRegistrationForm;

public class VehicleConverter {

    public static Vehicle buildVehicleObject(VehicleRegistrationForm vehicleRegistrationForm) {
        Vehicle vehicleToBeRegistered = new Vehicle();
        vehicleToBeRegistered.setBrand(vehicleRegistrationForm.getBrand());
        vehicleToBeRegistered.setModel(vehicleRegistrationForm.getModel());
        vehicleToBeRegistered.setLicenseplate(vehicleRegistrationForm.getLicenseplates());
        vehicleToBeRegistered.setFactoryDate(vehicleRegistrationForm.getFactorydate());
        vehicleToBeRegistered.setColour(vehicleRegistrationForm.getColour());
        vehicleToBeRegistered.setUservat(vehicleRegistrationForm.getUservat());
        return vehicleToBeRegistered;
    }
}
