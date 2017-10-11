package com.rgcs_motors.RGCS_Service_Management.repositories;

import com.rgcs_motors.RGCS_Service_Management.domain.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

    Users findByVatAndPassword(String vat, String password);


}
