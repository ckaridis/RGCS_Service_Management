package com.rgcs_motors.RGCS_Service_Management.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RepairRegistrationForm {


    private static final String LICENSEPLATES_PATTERN = "[a-zA-Z]{3}-[0-9]{4}";
    private static final String REPAIRCOST_PATTERN = "\\d+";
    private final static String NO_NUMBERS = "^[\\D]*$";

    private int id;


    @NotNull(message = "{register.licenseplates.null}")
    @Pattern(regexp = LICENSEPLATES_PATTERN, message = "{register.licenseplates.invalid}")
    private String licenseplates;

    @NotNull(message = "{register.repairdate.null}")
    private String repairdate;

    @NotNull(message = "{register.status.null}")
    @Pattern(regexp = NO_NUMBERS, message = "{register.status.invalid}")
    private String status;

    @NotNull(message = "{register.repairtype.null}")
    @Pattern(regexp = NO_NUMBERS, message = "{register.repairtype.invalid}")
    private String repairtype;

    @NotNull(message = "{register.repairCost.null}")
    @Pattern(regexp = REPAIRCOST_PATTERN, message = "{register.repairCost.invalid}")
    private String repairCost;

    @NotNull(message = "{register.repairDescription.null}")
    private String repairDescription;

    public String getLicenseplates() {
        return licenseplates;
    }

    public void setLicenseplates(String licenseplates) {
        this.licenseplates = licenseplates;
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

    public String getRepairtype() {
        return repairtype;
    }

    public void setRepairtype(String repairtype) {
        this.repairtype = repairtype;
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
