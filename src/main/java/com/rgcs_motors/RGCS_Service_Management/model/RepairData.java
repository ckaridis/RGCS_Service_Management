package com.rgcs_motors.RGCS_Service_Management.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepairData {

    private int id;

    private String licenseplates;

    private String status;

    private String repairtype;

    private String repaircost;

    private String description;

    private String repairDate;

    private String registrationDate;

    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public String getLicenseplates () {
        return licenseplates;
    }

    public void setLicenseplates ( String licenseplates ) {
        this.licenseplates = licenseplates;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus ( String status ) {
        this.status = status;
    }

    public String getRepairtype () {
        return repairtype;
    }

    public void setRepairtype ( String repairtype ) {
        this.repairtype = repairtype;
    }

    public String getRepaircost () {
        return repaircost;
    }

    public void setRepaircost ( String repaircost ) {
        this.repaircost = repaircost;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public String getRepairDate () {
        return repairDate;
    }

    public void setRepairDate ( String repairDate ) {
        this.repairDate = repairDate;
    }

    public String getRegistrationDate () {
        return registrationDate;
    }

    public void setRegistrationDate ( String registrationDate ) {
        this.registrationDate = registrationDate;
    }
}
