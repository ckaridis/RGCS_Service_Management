package com.rgcs_motors.RGCS_Service_Management.controller;

import com.rgcs_motors.RGCS_Service_Management.domain.Repair;
import com.rgcs_motors.RGCS_Service_Management.services.AdminHomeService;
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
public class AdminController {

    private static final String REPAIRS_FOR_ADMIN = "AdminRepairs";
    private static final String ADMIN_EMAIL = "AdminEmail";


    @Autowired
    private AdminHomeService adminHomeService;

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String adminPage(Model model, @RequestParam(name = "error", required = false) String error) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        model.addAttribute(ADMIN_EMAIL, username);

        List<Repair> repairs = new ArrayList<Repair>();
        try {
            repairs = adminHomeService.fetchRepairsForAdmin();
            System.out.println("the firtttttt element is "+ repairs.get(0).getLicensePlates());
        } catch (Exception e) {

            error = e.getMessage().toString();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>Error caught :" + error);
        }
        System.out.println("the firt element is "+ repairs.get(0).getLicensePlates());
        if (!repairs.isEmpty()) {
            System.out.println("Admin repairs list added to model");
            model.addAttribute(REPAIRS_FOR_ADMIN, repairs);
        }
        if (error != null) {
            model.addAttribute("errorMessage",error);
        }
        return "/admin/home";
    }
}
