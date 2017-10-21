package com.rgcs_motors.RGCS_Service_Management.services;

import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SearchServiceImpl implements SearchService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User searchUserByVatAndEmail(String vat, String email) throws Exception {
        User user;
        try {
            user= userRepository.findByEmailAndVat(email,vat);
            if(user == null)
            {
                throw new Exception("User not found!");
            }
        } catch (Exception e) {
            throw new Exception(e.getCause().toString());
        }
        return user;
    }

    @Override
    public User searchUserByVat(String vat) throws Exception {
        User user;
        try {
            user= userRepository.findByVat(vat);
            if(user == null)
            {
                throw new Exception("User not found!");
            }
        } catch (Exception e) {
            throw new Exception(e.getCause().toString());
        }
        return user;
    }

    @Override
    public User searchUserByEmail(String email) throws Exception {
        User user;
        try {
            user= userRepository.findByEmail(email);
            if(user == null)
            {
                throw new Exception("User not found!");
            }
        } catch (Exception e) {
            throw new Exception(e.getCause().toString());
        }
        return user;
    }
}
