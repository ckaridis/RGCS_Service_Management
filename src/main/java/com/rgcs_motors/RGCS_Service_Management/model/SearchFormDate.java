package com.rgcs_motors.RGCS_Service_Management.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class SearchFormDate {

    @NotNull(message = "{searchFormDate.validation.nullSearchDate}")
    private String date1;

    private String date2;

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }
}
