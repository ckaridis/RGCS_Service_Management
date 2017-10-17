package com.rgcs_motors.RGCS_Service_Management.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class UserRegisterController {
    @RequestMapping("/admin/createuser")
    String adminPage() {
        return "/admin/createuser";
    }
}
