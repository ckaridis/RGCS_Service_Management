package com.rgcs_motors.RGCS_Service_Management.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class OwnerRegistrationForm {

    //private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&]*$";
    private static final int PASSWORD_MINSIZE = 6;
    private static final int PASSWORD_MAXSIZE = 15;

    private static final String VAT_PATTERN = "^[1-9{9}]";

    private final static String NAME_PATTERN = "^[\\D]*$";

    @NotNull(message = "{register.password.null}")
    @Pattern(regexp = PASSWORD_PATTERN, message = "{register.password.invalid}")
    @Size(min = PASSWORD_MINSIZE, max = PASSWORD_MAXSIZE, message = "{register.password.size}")
    private String password;

    @NotNull(message = "{register.password.null}")
    @Pattern(regexp = PASSWORD_PATTERN, message = "{register.password.invalid}")
    @Size(min = PASSWORD_MINSIZE, max = PASSWORD_MAXSIZE, message = "{register.password.size}")
    private String confirmpassword;

    @NotNull(message = "{register.vat.null}")
    @Pattern(regexp = VAT_PATTERN, message = "{register.vat.invalid}")
    private String vat;


    @NotNull(message = "{register.firstname.null}")
    @Pattern(regexp = NAME_PATTERN, message = "{register.firstname.invalid}")
    private String firstname;

    @NotNull(message = "{register.lastname.null}")
    @Pattern(regexp = NAME_PATTERN, message = "{register.lastname.invalid}")
    private String lastname;

    @NotNull(message = "{register.address.null}")
    private String address;

    @NotNull(message = "{register.mail.null}")
    private String email;

    @NotNull(message = "{register.type.null}")
    private String user_type;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return user_type;
    }

    public void setType(String type) {
        this.user_type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
