package com.rgcs_motors.RGCS_Service_Management.controller;

import com.rgcs_motors.RGCS_Service_Management.domain.Repair;
import com.rgcs_motors.RGCS_Service_Management.services.UserHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserHomeController {
    
    private final String REPAIRS_FOR_USER = "repair";

    @Autowired
    private UserHomeService userHomeService;

    @RequestMapping(value = "/owner/home", method = RequestMethod.GET)
    public String showOwnerHomePage(Model model, @RequestParam(name = "error", required = false) String error)
    {

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> gets username from authentication context object
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> calls userHomeService with the username as parameter
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> the service returns all the services for the user with that username
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> adds the list of services to the view model
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> shows the view

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>username from auth: " + username);

        List<Repair> repairs = new ArrayList<>();
        try {
            repairs = userHomeService.fetchServicesForUser(username);
        } catch (Exception e) {
            error = e.getMessage().toString();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>Error caught :" + error);
        }

        if(!repairs.isEmpty()) {
            System.out.println("repairs list added to model");
            model.addAttribute(REPAIRS_FOR_USER, repairs);
        }

        if(error != null) {
            model.addAttribute("errorMessage",error);
        }

        return "/owner/home";
    }
}
