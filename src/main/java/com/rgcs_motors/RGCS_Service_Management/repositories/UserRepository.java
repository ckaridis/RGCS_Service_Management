package com.rgcs_motors.RGCS_Service_Management.repositories;

import com.rgcs_motors.RGCS_Service_Management.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmailAndPassword(String email, String password) throws Exception;

    User findByEmail(String email) throws Exception;

    User findByVat(String vat) throws Exception;

    User findByEmailAndVat(String email, String vat) throws Exception;

    User save(User user);
}
