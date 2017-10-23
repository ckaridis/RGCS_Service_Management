package com.rgcs_motors.RGCS_Service_Management.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class VehicleRegistrationForm {

    private static final String LICENSEPLATES_PATTERN = "[a-zA-Z]{3}-[0-9]{4}";
    private static final String FACTORYDATE_PATTERN = "[0-9]{4}";
    private static final String COLOUR_PATTERN = "^[a-zA-Z\\s]+";
    private static final String USERVAT_PATTERN = "^[1-9]{9}";

    private int id;

    @NotNull(message = "{register.brand.null}")
    private String brand;

    @NotNull(message = "{register.model.null}")
    private String model;

    @NotNull(message = "{register.licenseplates.null}")
    @Pattern(regexp = LICENSEPLATES_PATTERN, message = "{register.licenseplates.invalid}")
    private String licenseplates;

    @NotNull(message = "{register.factorydate.null}")
    @Pattern(regexp = FACTORYDATE_PATTERN, message = "{register.factorydate.invalid}")
    private String factorydate;

    @NotNull(message = "{register.colour.null}")
    @Pattern(regexp = COLOUR_PATTERN, message = "{register.colour.invalid}")
    private String colour;

    @NotNull(message = "{register.uservat.null}")
    @Pattern(regexp = USERVAT_PATTERN, message = "{register.uservat.invalid}")
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
