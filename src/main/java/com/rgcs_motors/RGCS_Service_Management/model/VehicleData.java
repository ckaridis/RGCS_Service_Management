package com.rgcs_motors.RGCS_Service_Management.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleData {

    private int id;

    private String brand;

    private String model;

    private String licenseplates;

    private String factorydate;

    private String colour;

    @JsonProperty("uservat")
    private String uservat;


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

    public String getLicenseplates() {
        return licenseplates;
    }

    public void setLicenseplates(String licenseplates) {
        this.licenseplates = licenseplates;
    }

    public String getFactorydate() {
        return factorydate;
    }

    public void setFactorydate(String factorydate) {
        this.factorydate = factorydate;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getUservat() {
        return uservat;
    }

    public void setUservat(String uservat) {
        this.uservat = uservat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
