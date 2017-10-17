package com.rgcs_motors.RGCS_Service_Management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VehicleRegisterController {
    @RequestMapping("/admin/CreateVehicle")
    String adminPage() {
        return "/admin/createvehicle";
    }
}
