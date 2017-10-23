package com.rgcs_motors.RGCS_Service_Management.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class SearchForm {

    @NotNull(message = "{searchForm.validation.nullSearchType}")
    private String searchtype;

    @NotNull(message = "{searchForm.validation.nullSearchValue}")
    private String searchval;





    public String getSearchtype() {
        return searchtype;
    }

    public void setSearchtype(String searchtype) {
        this.searchtype = searchtype;
    }

    public String getSearchval() {
        return searchval;
    }

    public void setSearchval(String searchval) {
        this.searchval = searchval;
    }
}
