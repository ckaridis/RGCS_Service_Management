package com.rgcs_motors.RGCS_Service_Management.controller;

import com.rgcs_motors.RGCS_Service_Management.converters.UserConverter;
import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.model.OwnerRegistrationForm;
import com.rgcs_motors.RGCS_Service_Management.services.RegisterNewOwnerImpl;
import com.rgcs_motors.RGCS_Service_Management.services.RegisterNewOwnerService;
import com.rgcs_motors.RGCS_Service_Management.validators.OwnerRegistrationFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserRegisterController {

    private static final String REGISTER_FORM = "ownerRegistrationForm";
    private static final String failedRegistrationMessage = "Registration proccess failed";
    private static final String ADMIN_EMAIL = "AdminEmail";
    private static final String ADMIN_CREATEUSER_PAGE = "/admin/createuser";
    private static final String ADMIN_CREATEVEHICLE_PAGE = "/admin/createvehicle";
    private String redirectUrl = "";

    @Autowired
    private RegisterNewOwnerService registerNewOwnerService;

    @Autowired
    private OwnerRegistrationFormValidator formValidator;

    @GetMapping("/admin/createuser")
    String adminPage(Model model, RedirectAttributes redirectAttributes) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        model.addAttribute(ADMIN_EMAIL,username);

        if(!redirectAttributes.containsAttribute("returnedMessage"))
        {
            System.out.println("redirect attr msg : " + model.asMap().get("returnedMessage"));
            model.addAttribute(REGISTER_FORM, new OwnerRegistrationForm());
        }
        return ADMIN_CREATEUSER_PAGE;
    }

    @RequestMapping(value = "/admin/createuser", method = RequestMethod.POST)
    String registerUser(@Valid @ModelAttribute(REGISTER_FORM)
                                OwnerRegistrationForm registrationForm,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes)
    {

        System.out.println(registrationForm.getType());
        formValidator.validate(registrationForm, bindingResult);
        System.out.println("Field error : >>>> " + bindingResult.getFieldError("confirmpassword"));

        if (bindingResult.hasErrors()) {
            //redirect to the
            //get method after adding the binding result and the form to the redirect attributes.
            List<FieldError> errorsList = bindingResult.getFieldErrors();
            redirectAttributes.addFlashAttribute("errorsList",errorsList);
            System.out.println(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            redirectAttributes.addFlashAttribute("binding_result",bindingResult);
            redirectAttributes.addFlashAttribute(REGISTER_FORM,registrationForm);
            redirectAttributes.addFlashAttribute("returnedMessage",failedRegistrationMessage);
            redirectUrl = "redirect:" + ADMIN_CREATEUSER_PAGE;
        }
        else{
            try {
                User user = UserConverter.buildUserObject(registrationForm);
                System.out.println("user type is : " + user.getType());
                String result = registerNewOwnerService.registerNewOwner(user);
                redirectAttributes.addFlashAttribute("registrationResult",result);
                redirectAttributes.addFlashAttribute("vatNumber",user.getVat());
                redirectUrl = "redirect:" + ADMIN_CREATEVEHICLE_PAGE;
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
                redirectUrl = "redirect:" + ADMIN_CREATEUSER_PAGE;
            }
        }

        return redirectUrl;
    }
}
