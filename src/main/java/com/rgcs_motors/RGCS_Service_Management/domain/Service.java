package com.rgcs_motors.RGCS_Service_Management.domain;

import javax.persistence.*;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @Column (nullable = false, name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "VEHICLE_PLATE", nullable = false, unique = true)
    private String licensePlates;

    @Column(name = "registration_date", nullable = false)
    private String repairRegistrationDate;

    @Column(name = "service_date", nullable = false)
    private String repairDate;

    @Column(name = "status", nullable = false)
    private String repairStatus;

    @Column(name = "service_type", nullable = false)
    private String repairType;

    @Column(name = "service_cost", nullable = false)
    private double repairCost;

    @Column(name = "description", nullable = false)
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


    public Service()
    {}
    
    public Service(String licensePlates, String repairRegistrationDate, String repairDate, String repairStatus, String repairType, double repairCost, String repairDescription) {
        this.licensePlates = licensePlates;
        this.repairRegistrationDate = repairRegistrationDate;
        this.repairDate = repairDate;
        this.repairStatus = repairStatus;
        this.repairType = repairType;
        this.repairCost = repairCost;
        this.repairDescription = repairDescription;
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

    public int getId() {
        return id;
    }
}
