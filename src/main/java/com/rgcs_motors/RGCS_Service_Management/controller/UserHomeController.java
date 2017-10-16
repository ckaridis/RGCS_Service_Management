package com.rgcs_motors.RGCS_Service_Management.controller;

import com.rgcs_motors.RGCS_Service_Management.domain.Service;
import com.rgcs_motors.RGCS_Service_Management.services.UserHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

        List<Service> services = null;
        try {
            services = userHomeService.fetchServicesForUser(username);
        } catch (Exception e) {
            e.printStackTrace();
            error = e.getMessage().toString();
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>service list : " + services.toString());

        if(!services.isEmpty())
        {
            model.addAttribute("serviceList", services);
        }

        if(error != null)
        {
            model.addAttribute("errorMessage",error);
        }

        return "/owner/owner_home";
    }

}
