package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.User;

import java.util.List;

public interface SearchService {

    User searchUserByVatAndEmail(String vat, String email) throws Exception;
    User searchUserByVat(String vat) throws Exception;
    User searchUserByEmail(String email) throws Exception;
}
