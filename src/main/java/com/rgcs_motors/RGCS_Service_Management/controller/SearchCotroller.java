package com.rgcs_motors.RGCS_Service_Management.controller;

import com.rgcs_motors.RGCS_Service_Management.converters.UserConverter;
import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.domain.Vehicle;
import com.rgcs_motors.RGCS_Service_Management.model.SearchForm;
import com.rgcs_motors.RGCS_Service_Management.services.SearchService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchCotroller {

    private final String SEARCH_PAGE = "/admin/SearchOVR";
    private static final String ADMIN_EMAIL = "AdminEmail";
    private static final String SEARCH_FORM = "searchForm";

    @Autowired
    private SearchForm form;

    @Autowired
    private SearchFormValidator searchFormValidator;

    @Autowired
    private SearchService searchService;

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

        if(searchForm.getSearchtype() != null)
        {
            searchTypeNotNullActions(searchForm, bindingResult, redirectAttributes);
        }
        return "redirect:" + SEARCH_PAGE;
    }

    private void searchTypeNotNullActions(@Valid @ModelAttribute(SEARCH_FORM) SearchForm searchForm,
                                       BindingResult bindingResult, RedirectAttributes redirectAttributes) {
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
        }
        else{
            switch(searchForm.getSearchtype())
            {
                case "Vehicle":
                    handleVehicleSearch(redirectAttributes);
                case "Owner":
                    handleUserSearch(redirectAttributes);
            }
        }
    }

    private void handleUserSearch(RedirectAttributes redirectAttributes) {
        try {
            Map<String,String> paramsMap = searchFormValidator.getSearchParamsMap();
            System.out.println("params mail: " + paramsMap.get("userMail"));
            if(paramsMap.containsKey("userVat") && paramsMap.containsKey("userMail")) {
                try{
                    System.out.println("retured user: oth");
                    User returnedUser = searchService.searchUserByVatAndEmail(paramsMap.get("userVat"),paramsMap.get("userMail"));
                    if(returnedUser != null) {
                        redirectAttributes.addFlashAttribute("searchedUser",returnedUser);
                    }
                }
                catch (Exception e) {
                    redirectAttributes.addFlashAttribute("searchErrorMessage",e.getCause());
                }
            }
            else if(paramsMap.containsKey("userVat"))
            {
                try{
                    System.out.println("retured user: vat");
                    User returnedUser = searchService.searchUserByVat(paramsMap.get("userVat"));
                    if(returnedUser != null) {
                        System.out.println("retured user added to model");
                        redirectAttributes.addFlashAttribute("searchedUser",returnedUser);
                    }
                }
                catch (Exception e) {
                    redirectAttributes.addFlashAttribute("searchErrorMessage",e.getCause());
                }
            }
            else{
                try{
                    System.out.println("retured user: mail");
                    System.out.println("params mail: " + paramsMap.get("userMail"));
                    User returnedUser = searchService.searchUserByEmail(paramsMap.get("userMail"));
                    System.out.println("retured user: " + returnedUser.getAddress());
                    if(returnedUser != null) {
                        System.out.println("retured user: " + returnedUser.getAddress());
                        redirectAttributes.addFlashAttribute("searchedUser",returnedUser);
                    }
                }
                catch (Exception e) {
                    redirectAttributes.addFlashAttribute("searchErrorMessage",e.getCause());
                }
            }
            searchFormValidator.clearSearchParamsMap();
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage",e.getCause().toString());
        }
    }// end of handleUserSearch()

    private void handleVehicleSearch(RedirectAttributes redirectAttributes) {
        try {
            Map<String,String> paramsMap = searchFormValidator.getSearchParamsMap();
            if(paramsMap.containsKey("userVat") && paramsMap.containsKey("userPlate")) {
                try{
                    List<Vehicle> vehicles = searchService.
                            searchVehicleByVatAndPlate(paramsMap.get("userVat"),paramsMap.get("userPlate"));
                    if(!vehicles.isEmpty()) {
                        redirectAttributes.addFlashAttribute("vehicles",vehicles);
                    }
                }
                catch (Exception e) {
                    redirectAttributes.addFlashAttribute("searchErrorMessage",e.getCause());
                }
            }
            else if(paramsMap.containsKey("userVat"))
            {
                try{
                    List<Vehicle> vehicles = searchService.
                            searchVehicleByVat(paramsMap.get("userVat"));
                    if(!vehicles.isEmpty()) {
                        redirectAttributes.addFlashAttribute("vehicles",vehicles);
                    }
                }
                catch (Exception e) {
                    redirectAttributes.addFlashAttribute("searchErrorMessage",e.getCause());
                }
            }
            else{
                try{
                    List<Vehicle> vehicles = searchService.
                            searchVehicleByPlate(paramsMap.get("userPlate"));
                    if(!vehicles.isEmpty()) {
                        redirectAttributes.addFlashAttribute("vehicles",vehicles);
                    }
                }
                catch (Exception e) {
                    redirectAttributes.addFlashAttribute("searchErrorMessage",e.getCause());
                }
            }
            searchFormValidator.clearSearchParamsMap();
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage",e.getCause().toString());
        }
    }// end of handleUserSearch()

}
