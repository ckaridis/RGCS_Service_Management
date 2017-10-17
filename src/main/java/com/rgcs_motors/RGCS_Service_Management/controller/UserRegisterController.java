package com.rgcs_motors.RGCS_Service_Management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserRegisterController {
    @RequestMapping("/admin/createuser")
    String adminPage() {
        return "/admin/createuser";
    }
}
