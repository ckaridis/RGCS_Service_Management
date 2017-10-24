package com.rgcs_motors.RGCS_Service_Management.controller;

import com.rgcs_motors.RGCS_Service_Management.converters.RepairConverter;
import com.rgcs_motors.RGCS_Service_Management.domain.Repair;
import com.rgcs_motors.RGCS_Service_Management.model.RepairRegistrationForm;
import com.rgcs_motors.RGCS_Service_Management.services.AdminHomeService;
import com.rgcs_motors.RGCS_Service_Management.services.EditRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private static final String REPAIRS_FOR_ADMIN = "AdminRepairs";
    private static final String ADMIN_EMAIL = "AdminEmail";
    private static final String SUCCESSFUL_REPAIR_EDIT_MESSAGE = "Repair updated successfully";
    private static final String REPAIR_REGISTER_FORM = "RepairRegistrationForm";
    private static final String ADMIN_PAGE = "/admin/home";
    private String redirectUrl = "";
    @Autowired
    private EditRepairService editRepairService;


    @Autowired
    private AdminHomeService adminHomeService;

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String adminPage(Model model, @RequestParam(name = "error", required = false) String error) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        model.addAttribute(ADMIN_EMAIL,username);

        List<Repair> repairs = new ArrayList<Repair>();
        try {
            repairs = adminHomeService.fetchRepairsForAdmin();
            System.out.println("the firtttttt element is "+ repairs.get(0).getLicenseplate());

        } catch (Exception e) {

            error = e.getMessage().toString();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>Error caught :" + error);
        }
        if (!repairs.isEmpty()) {
            System.out.println("Admin repairs list added to model");
            model.addAttribute(REPAIRS_FOR_ADMIN, repairs);
        }
        if (error != null) {
            model.addAttribute("errorMessage",error);
        }
        return "/admin/home";
    }

    @PostMapping("/admin/editRepair")
    public String editAdminRepair(@Valid @ModelAttribute(REPAIR_REGISTER_FORM)
                                 RepairRegistrationForm repairRegistrationForm,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            List<FieldError> errorsListmodal = bindingResult.getFieldErrors();
            redirectAttributes.addFlashAttribute("errorsList_modal",errorsListmodal);
            redirectAttributes.addFlashAttribute("binding_result_modal",bindingResult);
            redirectAttributes.addFlashAttribute(REPAIR_REGISTER_FORM,repairRegistrationForm);
            redirectUrl = "redirect:" + ADMIN_PAGE;
        }
        else{
            try {
                Repair repair = RepairConverter.buildRepairObject(repairRegistrationForm);
                System.out.println("form id : "+repairRegistrationForm.getId());
                repair.setId(repairRegistrationForm.getId());
                Repair editedRepair = editRepairService.editRepair(repair);
                redirectAttributes.addFlashAttribute("success_modal",SUCCESSFUL_REPAIR_EDIT_MESSAGE);
                redirectUrl = "redirect:" + ADMIN_PAGE;
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage_modal", e.getMessage());
                redirectUrl = "redirect:" + ADMIN_PAGE;
            }
        }
        return redirectUrl;
    }
}
