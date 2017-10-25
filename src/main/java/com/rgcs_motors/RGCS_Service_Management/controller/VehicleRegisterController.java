package com.rgcs_motors.RGCS_Service_Management.controller;

import com.rgcs_motors.RGCS_Service_Management.converters.VehicleConverter;
import com.rgcs_motors.RGCS_Service_Management.domain.Vehicle;
import com.rgcs_motors.RGCS_Service_Management.model.VehicleRegistrationForm;
import com.rgcs_motors.RGCS_Service_Management.services.RegisterNewVehicleService;
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
public class VehicleRegisterController {

    private static final String ADMIN_EMAIL = "AdminEmail";
    private static final String VEHICLE_REGISTER_FORM = "VehicleRegistrationForm";
    private static final String ADMIN_CREATE_VEHICLE_PAGE = "/admin/CreateVehicle";
    private static final String FAILED_REGISTRATION_MESSAGE = "Registration process failed";
    private static final String ADMIN_CREATE_REPAIR_PAGE = "/admin/CreateRepair";
    private String redirectUrl = "";

    @Autowired
    private RegisterNewVehicleService registerNewVehicleService;

    @RequestMapping(value = "/admin/CreateVehicle", method = RequestMethod.GET)
    String adminPage(Model model, RedirectAttributes redirectAttributes) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        model.addAttribute(ADMIN_EMAIL,username);

        if(!redirectAttributes.containsAttribute("returnedMessage")) {

            System.out.println("redirect attr msg : " + model.asMap().get("returnedMessage"));
            model.addAttribute(VEHICLE_REGISTER_FORM, new VehicleRegistrationForm());
        }
        return ADMIN_CREATE_VEHICLE_PAGE;
    }

    @RequestMapping(value = "/admin/CreateVehicle", method = RequestMethod.POST)
    String registerVehicle(@Valid @ModelAttribute(VEHICLE_REGISTER_FORM) VehicleRegistrationForm registrationForm,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            //redirect to the
            //get method after adding the binding result and the form to the redirect attributes.
            List<FieldError> errorsList = bindingResult.getFieldErrors();
            redirectAttributes.addFlashAttribute("errorsList",errorsList);
            System.out.println(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            redirectAttributes.addFlashAttribute("binding_result_vehicle",bindingResult);
            redirectAttributes.addFlashAttribute(VEHICLE_REGISTER_FORM,registrationForm);
            redirectAttributes.addFlashAttribute("returnedMessage", FAILED_REGISTRATION_MESSAGE);
            redirectUrl = "redirect:" + ADMIN_CREATE_VEHICLE_PAGE;
        }
        else {
            try {
                Vehicle vehicle = VehicleConverter.buildVehicleObject(registrationForm);
                String result = registerNewVehicleService.registerNewVehicle(vehicle);
                System.out.println("Successful Registration!!");
                redirectAttributes.addFlashAttribute("licensePlates",vehicle.getLicenseplate());
                redirectUrl = "redirect:" + ADMIN_CREATE_REPAIR_PAGE;
            } catch (Exception e) {
                    redirectAttributes.addFlashAttribute("errorMessage", e.getCause().toString());
                    redirectUrl = "redirect:" + ADMIN_CREATE_VEHICLE_PAGE;
            }
        }
        return redirectUrl;
    }
}
