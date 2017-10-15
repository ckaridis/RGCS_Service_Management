package com.rgcs_motors.RGCS_Service_Management.controller;

import com.rgcs_motors.RGCS_Service_Management.domain.Service;
import com.rgcs_motors.RGCS_Service_Management.services.UserHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserHomeController {

    @Autowired
    private UserHomeService userHomeService;

    @RequestMapping(value = "owner", method = RequestMethod.GET)
    public void showOwnerHomePage(Model model, @RequestParam(name = "error", required = false) String error)
    {
        String username = "";
        List<Service> services = userHomeService.fetchServicesForUser(username);
    }
}
