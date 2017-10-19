package com.rgcs_motors.RGCS_Service_Management.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VehicleRegisterController {

    private static final String ADMIN_EMAIL = "AdminEmail";

    @RequestMapping("/admin/CreateVehicle")
    String adminPage(Model model, RedirectAttributes redirectAttributes) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        model.addAttribute(ADMIN_EMAIL,username);

        return "/admin/createvehicle";
    }
}
