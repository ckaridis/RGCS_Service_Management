package com.rgcs_motors.RGCS_Service_Management.domain;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @Column(nullable = false, name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, name = "brand")
    private String brand;

    @Column(nullable = false, name = "model")
    private String model;

    @Column(nullable = false, name = "licenseplate", unique = true)
    private String licenseplate;

    @Column(nullable = false, name = "productionyear")
    private String factoryDate;

    @Column(nullable = false, name = "color")
    private String colour;

    @Column(nullable = false, name = "uservat")
    private String uservat;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, String licenseplate, String factoryDate, String colour, String uservat) {
        this.brand = brand;
        this.model = model;
        this.licenseplate = licenseplate;
        this.factoryDate = factoryDate;
        this.colour = colour;
        this.uservat = uservat;
    }

    public String getUservat() {
        return uservat;
    }

    public void setUservat(String uservat) {
        this.uservat = uservat;
    }

    public void setAfm(String uservat) {
        this.uservat = uservat;
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

    public String getLicensePlate() {
        return licenseplate;
    }

    public void setLicensePlate(String licenseplate) {
        this.licenseplate = licenseplate;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
