package com.rgcs_motors.RGCS_Service_Management.controller;

import com.rgcs_motors.RGCS_Service_Management.model.OwnerRegistrationForm;
import com.rgcs_motors.RGCS_Service_Management.model.VehicleRegistrationForm;
import com.rgcs_motors.RGCS_Service_Management.services.RegisterNewVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class VehicleRegisterController {

    private static final String ADMIN_EMAIL = "AdminEmail";
    private static final String VEHICLE_REGISTER_FORM = "vehicleRegistrationForm";
    private static final String ADMIN_CREATE_VEHICLE_PAGE = "/admin/createvehicle";



    @Autowired
    private RegisterNewVehicleService registerNewVehicleService;

    @RequestMapping(value = "/admin/CreateVehicle", method = RequestMethod.GET)
    String adminPage(Model model, RedirectAttributes redirectAttributes) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        model.addAttribute(ADMIN_EMAIL,username);

        if(!redirectAttributes.containsAttribute("returnedMessage")) {

            System.out.println("redirect attr msg : " + model.asMap().get("returnedMessage"));
            model.addAttribute(VEHICLE_REGISTER_FORM, new VehicleRegistrationForm());
        }
        return ADMIN_CREATE_VEHICLE_PAGE;
    }

    @RequestMapping(value = "/admin/createuser", method = RequestMethod.POST)
    String registerVehicle(@Valid @ModelAttribute(VEHICLE_REGISTER_FORM) VehicleRegistrationForm registrationForm,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        return VEHICLE_REGISTER_FORM;
    }
}
