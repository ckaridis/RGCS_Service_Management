package com.rgcs_motors.RGCS_Service_Management.domain;

import javax.persistence.*;
import java.util.Date;

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
    private Date repairRegistrationDate;

    @Column(name = "service_date", nullable = false)
    private Date repairDate;

    @Column(name = "status", nullable = false)
    private String repairStatus;

    @Column(name = "service_type", nullable = false)
    private String repairType;

    @Column(name = "service_cost", nullable = false)
    private String repairCost;

    @Column(name = "description", nullable = false)
    private String repairDescription;


    public Service() {
    }

    public Service(String licensePlates, Date repairRegistrationDate, Date repairDate, String repairStatus, String repairType, String repairCost, String repairDescription) {
        this.licensePlates = licensePlates;
        this.repairRegistrationDate = repairRegistrationDate;
        this.repairDate = repairDate;
        this.repairStatus = repairStatus;
        this.repairType = repairType;
        this.repairCost = repairCost;
        this.repairDescription = repairDescription;
    }


    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public Date getRepairRegistrationDate() {
        return repairRegistrationDate;
    }

    public void setRepairRegistrationDate(Date repairRegistrationDate) {
        this.repairRegistrationDate = repairRegistrationDate;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
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

    public String getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(String repairCost) {
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
