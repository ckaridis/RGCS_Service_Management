package com.rgcs_motors.RGCS_Service_Management.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name="users")
public class User implements Serializable{

    @Id
    @Column (nullable = false, name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, name = "VAT", unique=true)
    private String vat;

    @Column(nullable = false, name = "name")
    private String firstName;

    @Column(nullable = false, name = "surname")
    private String lastName;

    @Column(nullable = false, name = "address")
    private String address;

    @Column(nullable = false, name = "email", unique=true)
    private String email;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false, name = "user_type")
    private String type;

    public User () {
    }

    public User ( String vat, String password, String firstName, String lastName, String address,
                  String email, String type) {

        this.vat = vat;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.email = email;
        this.type = type;

    }

    public Boolean checkType(){
        return this.type != null;
    }

    public int getId () {
        return id;
    }

    public String getVat () {
        return vat;
    }

    public void setVat ( String vat ) {
        this.vat = vat;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
