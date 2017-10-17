package com.rgcs_motors.RGCS_Service_Management.controller;

import com.rgcs_motors.RGCS_Service_Management.domain.Repair;
import com.rgcs_motors.RGCS_Service_Management.services.AdminHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private static String REPAIRS_FOR_ADMIN = "AdminRepairs";

    @Autowired
    private AdminHomeService adminHomeService;

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String adminPage(Model model, @RequestParam(name = "error", required = false) String error) {

        List<Repair> repairs = new ArrayList<>();
        repairs = adminHomeService.fetchRepairsForOwner();



        return "/admin/home";
    }
}
