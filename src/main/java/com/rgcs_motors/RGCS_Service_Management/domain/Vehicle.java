package com.rgcs_motors.RGCS_Service_Management.domain;

public class Vehicle {

    private String brand;
    private String model;
    private String licensePlates;
    private String factoryDate;
    private String colour;
    private String afm;

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getFactoryDate() {
        return factoryDate;
    }

    public void setFactoryDate(String factoryDate) {
        this.factoryDate = factoryDate;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
