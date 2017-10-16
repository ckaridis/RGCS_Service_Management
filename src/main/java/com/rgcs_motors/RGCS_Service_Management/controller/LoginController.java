package com.rgcs_motors.RGCS_Service_Management.controller;

import com.rgcs_motors.RGCS_Service_Management.model.LoginForm;
import com.rgcs_motors.RGCS_Service_Management.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final String LOGIN_FORM = "loginForm";

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String indexPage(Model model, @RequestParam(name = "error", required = false) String error) { //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> updated yesterday
        if(error != null)
        {
            model.addAttribute("errorMessage",error);
        }
        model.addAttribute(LOGIN_FORM, new LoginForm ());
        return "index";
    }

    @RequestMapping("/accessDenied")
    String showErrorPage(Model model, @RequestParam(name = "error", required = false) String error) { //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> updated yesterday
        error = "User not found! Please try again";
        model.addAttribute("errorMessage",error);
        model.addAttribute(LOGIN_FORM, new LoginForm ());
        return "index";
    }
}//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> end of controller