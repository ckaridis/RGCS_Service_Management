package com.rgcs_motors.RGCS_Service_Management.controller;

import com.rgcs_motors.RGCS_Service_Management.converters.RepairConverter;
import com.rgcs_motors.RGCS_Service_Management.domain.Repair;
import com.rgcs_motors.RGCS_Service_Management.model.RepairRegistrationForm;
import com.rgcs_motors.RGCS_Service_Management.services.RegisterNewRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RepairRegisterController {

    private static final String ADMIN_EMAIL = "AdminEmail";
    private static final String REPAIR_REGISTER_FORM = "RepairRegistrationForm";
    private static final String ADMIN_CREATE_REPAIR_PAGE = "/admin/CreateRepair";
    private static final String FAILED_REGISTRATION_MESSAGE = "Registration repair process failed";
    private String redirectUrl = "";

    @Autowired
    private RegisterNewRepairService registerNewRepairService;

    @RequestMapping(value = "/admin/CreateRepair", method = RequestMethod.GET)
    String adminPage(Model model, RedirectAttributes redirectAttributes) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        model.addAttribute(ADMIN_EMAIL,username);

        if(!redirectAttributes.containsAttribute("returnedMessage")) {

            System.out.println("redirect attr msg : " + model.asMap().get("returnedMessage"));
            model.addAttribute(REPAIR_REGISTER_FORM, new RepairRegistrationForm());
        }
        return ADMIN_CREATE_REPAIR_PAGE;
    }

    @RequestMapping(value = "/admin/CreateRepair", method = RequestMethod.POST)
    String registerRepair(@Valid @ModelAttribute(REPAIR_REGISTER_FORM) RepairRegistrationForm registrationForm,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            //redirect to the
            //get method after adding the binding result and the form to the redirect attributes.
            List<FieldError> errorsList = bindingResult.getFieldErrors();
            redirectAttributes.addFlashAttribute("errorsList",errorsList);
            System.out.println(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            redirectAttributes.addFlashAttribute("binding_result",bindingResult);
            redirectAttributes.addFlashAttribute(REPAIR_REGISTER_FORM,registrationForm);
            redirectAttributes.addFlashAttribute("returnedMessage", FAILED_REGISTRATION_MESSAGE);
            redirectUrl = "redirect:" + ADMIN_CREATE_REPAIR_PAGE;
        }
        else {
            try {
                Repair repair = RepairConverter.buildRepairObject(registrationForm);
                String result = registerNewRepairService.registerNewRepair(repair);
                System.out.println("Successful Registration!!");
                redirectUrl = "redirect:" + ADMIN_CREATE_REPAIR_PAGE;
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", e.getCause().toString());
                redirectUrl = "redirect:" + ADMIN_CREATE_REPAIR_PAGE;
            }
        }
        return redirectUrl;
    }
}
