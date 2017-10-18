package com.rgcs_motors.RGCS_Service_Management.controller;

import com.rgcs_motors.RGCS_Service_Management.converters.UserConverter;
import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.model.OwnerRegistrationForm;
import com.rgcs_motors.RGCS_Service_Management.services.RegisterNewOwnerImpl;
import com.rgcs_motors.RGCS_Service_Management.services.RegisterNewOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserRegisterController {

    private static final String REGISTER_FORM = "ownerRegistrationForm";
    private static final String failedRegistrationMessage = "Registration proccess failed";

    @Autowired
    private RegisterNewOwnerService registerNewOwnerService;

    @GetMapping("/admin/createuser")
    String adminPage(Model model, RedirectAttributes redirectAttributes) {
        if(!redirectAttributes.containsAttribute("returnedMessage"))
        {
            System.out.println("redirect attr msg : " + model.asMap().get("returnedMessage"));
            model.addAttribute(REGISTER_FORM, new OwnerRegistrationForm());
        }
        return "/admin/createuser";
    }

    @RequestMapping(value = "/admin/createuser", method = RequestMethod.POST)
    String registerUser(@Valid @ModelAttribute(REGISTER_FORM)
                                OwnerRegistrationForm registrationForm,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes)
    {

        if (bindingResult.hasErrors()) {
            //redirect to the
            //get method after adding the binding result and the form to the redirect attributes.
            System.out.println(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            redirectAttributes.addFlashAttribute("binding_result",bindingResult);
            redirectAttributes.addFlashAttribute(REGISTER_FORM,registrationForm);
            redirectAttributes.addFlashAttribute("returnedMessage",failedRegistrationMessage);
        }

        try {
            User user = UserConverter.buildUserObject(registrationForm);
            System.out.println("user type is : " + user.getType());
            String result = registerNewOwnerService.registerNewOwner(user);
            redirectAttributes.addFlashAttribute("registrationResult",result);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/admin/createuser";
    }
}
