package com.rgcs_motors.RGCS_Service_Management.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SearchCotroller {

    private final String SEARCH_PAGE = "/admin/SearchOVR";
    private static final String ADMIN_EMAIL = "AdminEmail";

    @GetMapping("/admin/SearchOVR")
    public String showSearchPage(Model model, RedirectAttributes redirectAttributes) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        model.addAttribute(ADMIN_EMAIL,username);

        return SEARCH_PAGE;
    }
}
