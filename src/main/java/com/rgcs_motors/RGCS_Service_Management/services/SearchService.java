package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.Repair;
import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.domain.Vehicle;

import java.util.List;

public interface SearchService {

    User searchUserByVatAndEmail(String vat, String email) throws Exception;
    User searchUserByVat(String vat) throws Exception;
    User searchUserByEmail(String email) throws Exception;

    List<Vehicle> searchVehicleByVatAndPlate(String uservat, String licenseplate) throws Exception;
    List<Vehicle> searchVehicleByVat(String uservat) throws Exception;
    List<Vehicle> searchVehicleByPlate(String licenseplate) throws Exception;

    List<Repair>  searchRepairByPlate(String licenseplate) throws Exception;
    List<Repair>  searchRepairByVat(String uservat) throws Exception;

    List<Repair> searchRepairByDate(String date) throws Exception;
    List<Repair> searchRepairByDates(String date1, String date2) throws Exception;
}
