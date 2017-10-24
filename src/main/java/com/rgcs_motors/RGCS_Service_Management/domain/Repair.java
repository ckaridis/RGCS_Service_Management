package com.rgcs_motors.RGCS_Service_Management.domain;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "repairs")
public class Repair {

    @Id
    @Column (nullable = false, name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "licenseplate", nullable = false, unique = true)
    private String licenseplate;

    @Column(name = "registrationdate", nullable = false)
    private Date repairRegistrationDate;

    @Column(name = "repairdate", nullable = false)
    private String repairdate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "repairtype", nullable = false)
    private String repairType;

    @Column(name = "repaircost", nullable = false)
    private String repairCost;

    @Column(name = "description", nullable = false)
    private String repairDescription;

    public Repair() {
    }

    public Repair(String licenseplate, Date repairRegistrationDate, String repairdate, String status, String repairType, String repairCost, String repairDescription) {
        this.licenseplate = licenseplate;
        this.repairRegistrationDate = repairRegistrationDate;
        this.repairdate = repairdate;
        this.status = status;
        this.repairType = repairType;
        this.repairCost = repairCost;
        this.repairDescription = repairDescription;
    }


    public String getLicenseplate() {
        return licenseplate;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate;
    }

    //@Temporal(TemporalType.TIMESTAMP)
    public Date getRepairRegistrationDate() {
        return repairRegistrationDate;
    }

    public void setRepairRegistrationDate(Date repairRegistrationDate) {
        this.repairRegistrationDate = repairRegistrationDate;
    }

    public String getRepairdate() {
        return repairdate;
    }

    public void setRepairdate(String repairdate) {
        this.repairdate = repairdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public void setId(int id) {
        this.id = id;
    }
}
