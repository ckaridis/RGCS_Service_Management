package com.rgcs_motors.RGCS_Service_Management.repositories;

import com.rgcs_motors.RGCS_Service_Management.domain.Service;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Long> {

    Service findByVehicleplate(String vehicleplate);
}
