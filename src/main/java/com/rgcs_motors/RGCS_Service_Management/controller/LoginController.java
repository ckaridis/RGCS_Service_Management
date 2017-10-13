package com.rgcs_motors.RGCS_Service_Management.controller;

import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.model.LoginForm;
import com.rgcs_motors.RGCS_Service_Management.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {

    private static final String LOGIN_FORM = "loginForm";

    @Autowired
    private LoginService loginService;

    @RequestMapping("/")
    String indexPage(Model model) {

        model.addAttribute(LOGIN_FORM, new LoginForm ());

        return "index";
    }

    @RequestMapping (value = "/loginValidation", method = RequestMethod.POST)
    public String loginValidation( @Valid @ModelAttribute(LOGIN_FORM) LoginForm loginForm ){

        System.out.println (">>>>>>>>>>>>>>>>>>>>>>" + loginForm.getEmail () + loginForm.getPassword () );
        loginForm.setEmail ( "test@test.com" );
        System.out.println (">>>>>>>>>>>>>>>>>>>>>>" + loginForm.getEmail () + loginForm.getPassword () );

        User user = loginService.login ( loginForm.getEmail (), loginForm.getPassword () );

        if (user.getType ().equals ( "Admin" )){
            return "redirect:/admin";
        }
        return "redirect:/user";
    }



}