package com.rgcs_motors.RGCS_Service_Management.domain;

public class Service {

    private String licensePlates;
    private String repairRegistrationDate;
    private String repairDate;
    private String repairStatus;
    private String repairType;
    private double repairCost;
    private String repairDescription;

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getRepairRegistrationDate() {
        return repairRegistrationDate;
    }

    public void setRepairRegistrationDate(String repairRegistrationDate) {
        this.repairRegistrationDate = repairRegistrationDate;
    }

    public String getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(String repairDate) {
        this.repairDate = repairDate;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public double getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(double repairCost) {
        this.repairCost = repairCost;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }
}
