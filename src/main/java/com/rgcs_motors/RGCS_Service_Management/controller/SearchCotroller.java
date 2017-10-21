package com.rgcs_motors.RGCS_Service_Management.controller;

import com.rgcs_motors.RGCS_Service_Management.converters.UserConverter;
import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.model.SearchForm;
import com.rgcs_motors.RGCS_Service_Management.validators.SearchFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class SearchCotroller {

    private final String SEARCH_PAGE = "/admin/SearchOVR";
    private static final String ADMIN_EMAIL = "AdminEmail";
    private static final String SEARCH_FORM = "searchForm";
    private static final String FAILED_REGISTRATION_MESSAGE = "Registration proccess failed";

    @Autowired
    private SearchForm form;

    @Autowired
    private SearchFormValidator searchFormValidator;

    @GetMapping("/admin/SearchOVR")
    public String showSearchPage(Model model, RedirectAttributes redirectAttributes) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        model.addAttribute(ADMIN_EMAIL,username);

        model.addAttribute(SEARCH_FORM, new SearchForm());

        return SEARCH_PAGE;
    }

    @PostMapping("/admin/SearchOVR")
    public String search(@Valid @ModelAttribute(SEARCH_FORM) SearchForm searchForm,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        System.out.println("form type : " + searchForm.getSearchtype());
        System.out.println("form value : " + searchForm.getSearchval());
        searchFormValidator.validate(searchForm, bindingResult);
        System.out.println("Field error : >>>> " + bindingResult.getFieldError("searchval"));

        if (bindingResult.hasErrors()) {
            //redirect to the
            //get method after adding the binding result and the form to the redirect attributes.
            List<FieldError> errorsList = bindingResult.getFieldErrors();
            redirectAttributes.addFlashAttribute("errorsList",errorsList);
            System.out.println(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            redirectAttributes.addFlashAttribute("binding_result",bindingResult);
            redirectAttributes.addFlashAttribute(SEARCH_FORM,searchForm);
            redirectAttributes.addFlashAttribute("returnedMessage", FAILED_REGISTRATION_MESSAGE);
        }
        else{
            try {
                Map<String,String> paramsMap = searchFormValidator.getSearchParamsMap();
                if(paramsMap.containsKey("userVat") && paramsMap.containsKey("userMail"))
                {}
                else if(paramsMap.containsKey("userVat"))
                {}
                else{}
                //check search type
                //run search
            } catch (Exception e) {
                //catch Exception
            }
        }
        return "redirect:" + SEARCH_PAGE;
    }
}
