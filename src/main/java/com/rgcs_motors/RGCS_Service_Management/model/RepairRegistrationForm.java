package com.rgcs_motors.RGCS_Service_Management.model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RepairRegistrationForm {


    private static final String LICENSEPLATES_PATTERN = "[a-zA-Z]{3}-[0-9]{4}";
    private static final String REPAIRCOST_PATTERN = "[\\D]*$";
    private final static String NO_NUMBERS = "^[\\D]*$";


    @NotNull(message = "{register.licenseplate.null}")
    @Pattern(regexp = LICENSEPLATES_PATTERN, message = "{register.licenseplates.invalid}")
    private String licenseplates;

    @NotNull(message = "{register.repairregistrationdate.null}")
    private Date repairregistrationdate;

    @NotNull(message = "{register.repairdate.null}")
    private Date repairdate;

    @NotNull(message = "{register.status.null}")
    @Pattern(regexp = NO_NUMBERS, message = "{register.licenseplates.invalid}")
    private String status;

    @NotNull(message = "{register.repairtype.null}")
    @Pattern(regexp = NO_NUMBERS, message = "{register.licenseplates.invalid}")
    private String repairtype;

    @NotNull(message = "{register.repairCost.null}")
    @Pattern(regexp = REPAIRCOST_PATTERN, message = "{register.licenseplates.invalid}")
    private String repairCost;

    @NotNull(message = "{register.repairDescription.null}")
    private String repairDescription;

    public String getLicenseplates() {
        return licenseplates;
    }

    public void setLicenseplates(String licenseplates) {
        this.licenseplates = licenseplates;
    }

    public Date getRepairregistrationdate() {
        return repairregistrationdate;
    }

    public void setRepairregistrationdate(Date repairregistrationdate) {
        this.repairregistrationdate = repairregistrationdate;
    }

    public Date getRepairdate() {
        return repairdate;
    }

    public void setRepairdate(Date repairdate) {
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
}
