package com.rgcs_motors.RGCS_Service_Management.controller;

import com.rgcs_motors.RGCS_Service_Management.converters.*;
import com.rgcs_motors.RGCS_Service_Management.domain.Repair;
import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.domain.Vehicle;
import com.rgcs_motors.RGCS_Service_Management.model.*;
import com.rgcs_motors.RGCS_Service_Management.services.*;
import com.rgcs_motors.RGCS_Service_Management.validators.OwnerRegistrationFormValidator;
import com.rgcs_motors.RGCS_Service_Management.validators.SearchFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController {

    private final String SEARCH_PAGE = "/admin/SearchOVR";
    private static final String ADMIN_EMAIL = "AdminEmail";
    private static final String SEARCH_FORM = "searchForm";
    private static final String REGISTER_FORM = "ownerRegistrationForm";
    private static final String VEHICLE_REGISTER_FORM = "VehicleRegistrationForm";
    private static final String REPAIR_REGISTER_FORM = "RepairRegistrationForm";
    private static final String SUCCESSFUL_EDIT_MESSAGE = "User updated successfully";
    private static final String SUCCESSFUL_VEHICLE_EDIT_MESSAGE = "Vehicle updated successfully";
    private static final String SUCCESSFUL_REPAIR_EDIT_MESSAGE = "Repair updated successfully";
    private static final String SUCCESSFUL_VEHICLE_DELETION_MESSAGE = "Vehicle was deleted successfully";
    private static final String SUCCESSFUL_REPAIR_DELETION_MESSAGE = "Vehicle was deleted successfully";
    private static final String SUCCESSFUL_USER_DELETION_MESSAGE = "User was deleted successfully";

    private String redirectUrl = "";

    @Autowired
    private SearchForm form;

    @Autowired
    private SearchFormValidator searchFormValidator;

    @Autowired
    private OwnerRegistrationFormValidator registrationFormValidator;

    @Autowired
    private SearchService searchService;

    @Autowired
    private EditUserService editUserService;

    @Autowired
    private EditVehicleService editVehicleService;

    @Autowired
    private DeleteVehicleService deleteVehicleService;

    @Autowired
    private EditRepairService editRepairService;

    @Autowired
    private DeleteUserService deleteUserService;

    @Autowired
    private DeleteRepairService deleteRepairService;



    @GetMapping("/admin/SearchOVR")
    public String showSearchPage(Model model, RedirectAttributes redirectAttributes) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        model.addAttribute(ADMIN_EMAIL,username);

        model.addAttribute(SEARCH_FORM, new SearchForm());

        if(!redirectAttributes.containsAttribute("returnedMessage_modal"))
        {
            model.addAttribute(REGISTER_FORM, new OwnerRegistrationForm());
        }

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


    @PostMapping("/admin/edituser")
    public String search(@Valid @ModelAttribute(REGISTER_FORM)
                                     OwnerRegistrationForm registrationForm,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        registrationFormValidator.validate(registrationForm, bindingResult);

        if (bindingResult.hasErrors()) {
            List<FieldError> errorsListmodal = bindingResult.getFieldErrors();
            redirectAttributes.addFlashAttribute("errorsList_modal",errorsListmodal);
            redirectAttributes.addFlashAttribute("binding_result_modal",bindingResult);
            redirectAttributes.addFlashAttribute(REGISTER_FORM,registrationForm);
            redirectUrl = "redirect:" + SEARCH_PAGE;
        }
        else{
            try {
                User user = UserConverter.buildUserObject(registrationForm);
                user.setId(registrationForm.getId());
                User editedUser = editUserService.editUser(user);
                System.out.println("user was edited" + editedUser.getVat());
                redirectAttributes.addFlashAttribute("success_modal",SUCCESSFUL_EDIT_MESSAGE);
                redirectUrl = "redirect:" + SEARCH_PAGE;
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage_modal", e.getMessage());
                redirectUrl = "redirect:" + SEARCH_PAGE;
            }
        }

        return redirectUrl;
    }


    @PostMapping("/admin/editVehicle")
    public String search(@Valid @ModelAttribute(VEHICLE_REGISTER_FORM)
                                 VehicleRegistrationForm vehicleRegistrationForm,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            List<FieldError> errorsListmodal = bindingResult.getFieldErrors();
            redirectAttributes.addFlashAttribute("errorsList_modal",errorsListmodal);
            redirectAttributes.addFlashAttribute("binding_result_modal",bindingResult);
            redirectAttributes.addFlashAttribute(VEHICLE_REGISTER_FORM,vehicleRegistrationForm);
            redirectUrl = "redirect:" + SEARCH_PAGE;
        }
        else{
            try {
                Vehicle vehicle = VehicleConverter.buildVehicleObject(vehicleRegistrationForm);
                System.out.println("form id : "+vehicleRegistrationForm.getId());
                vehicle.setId(vehicleRegistrationForm.getId());
                Vehicle editedVehicle = editVehicleService.editVehicle(vehicle);
                System.out.println("user was edited" + editedVehicle.getBrand());
                redirectAttributes.addFlashAttribute("success_modal",SUCCESSFUL_VEHICLE_EDIT_MESSAGE);
                redirectUrl = "redirect:" + SEARCH_PAGE;
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage_modal", e.getMessage());
                redirectUrl = "redirect:" + SEARCH_PAGE;
            }
        }

        return redirectUrl;
    }


    @RequestMapping(value = "/admin/delVehicle", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteVehicle(@RequestBody VehicleData vehicleData,
                                              RedirectAttributes redirectAttributes) {
        try {
            Vehicle vehicle = VehicleFromJsoConverter.buildVehicleObjectFromJson(vehicleData);
            String deletionResult = deleteVehicleService.deleteVehicle(vehicle);
            redirectAttributes.addFlashAttribute("deletionResult",SUCCESSFUL_VEHICLE_DELETION_MESSAGE);
            System.out.println("Successful deletio!!");
            redirectUrl = "redirect:" + SEARCH_PAGE;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessageJson", e.getCause().toString());
        }

        return redirectUrl;
    }


    @RequestMapping(value = "/admin/delUser", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteUser(@RequestBody UserData userData,
                                              RedirectAttributes redirectAttributes) {
        System.out.println("so far so good");
        try {
            User user = UserFromJsonConverter.buildUserObjectFromJson(userData);
            String deletionResult = deleteUserService.deleteUser(user);
            redirectAttributes.addFlashAttribute("deletionResult",SUCCESSFUL_USER_DELETION_MESSAGE);
            System.out.println("Successful deletio!!");
            redirectUrl = "redirect:" + SEARCH_PAGE;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessageJson", e.getCause().toString());
        }

        return redirectUrl;
    }


    @RequestMapping(value = "/admin/delRepair", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteRepair(@RequestBody RepairData repairData,
                                              RedirectAttributes redirectAttributes) {
        System.out.println("delete repair");
        try {
            Repair repair = RepairFromJsonConverter.buildRepairObjectFromJson(repairData);
            System.out.println("repair from jso : " + repair.getRepairdate());
            String deletionResult = deleteRepairService.deleteRepair(repair);
            redirectAttributes.addFlashAttribute("deletionResult",SUCCESSFUL_REPAIR_DELETION_MESSAGE);
            System.out.println("Successful deletio!!");
            redirectUrl = "redirect:" + SEARCH_PAGE;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessageJson", e.getCause().toString());
        }

        return redirectUrl;
    }



    @PostMapping("/admin/search/editRepair")
    public String editRepair(@Valid @ModelAttribute(REPAIR_REGISTER_FORM)
                                 RepairRegistrationForm repairRegistrationForm,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            List<FieldError> errorsListmodal = bindingResult.getFieldErrors();
            redirectAttributes.addFlashAttribute("errorsList_modal",errorsListmodal);
            redirectAttributes.addFlashAttribute("binding_result_modal",bindingResult);
            redirectAttributes.addFlashAttribute(REPAIR_REGISTER_FORM,repairRegistrationForm);
            redirectUrl = "redirect:" + SEARCH_PAGE;
        }
        else{
            try {
                Repair repair = RepairConverter.buildRepairObject(repairRegistrationForm);
                System.out.println("form id : "+repairRegistrationForm.getId());
                repair.setId(repairRegistrationForm.getId());
                Repair editedRepair = editRepairService.editRepair(repair);
                System.out.println("user was edited" + editedRepair.getRepairdate());
                redirectAttributes.addFlashAttribute("success_modal",SUCCESSFUL_REPAIR_EDIT_MESSAGE);
                redirectUrl = "redirect:" + SEARCH_PAGE;
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage_modal", e.getMessage());
                redirectUrl = "redirect:" + SEARCH_PAGE;
            }
        }

        return redirectUrl;
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
                case "Repair":
                    handleRepairSearch(redirectAttributes);
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
    }// end of handleVehicleSearch()

    private void handleRepairSearch(RedirectAttributes redirectAttributes) {
        try {
            Map<String,String> paramsMap = searchFormValidator.getSearchParamsMap();
            if(paramsMap.containsKey("userVat"))
            {
                try{
                    List<Repair> repairs = searchService.
                            searchRepairByVat(paramsMap.get("userVat"));
                    if(!repairs.isEmpty()) {
                        redirectAttributes.addFlashAttribute("repairs",repairs);
                    }
                }
                catch (Exception e) {
                    redirectAttributes.addFlashAttribute("searchErrorMessage",e.getCause());
                }
            }
            else{
                try{
                    List<Repair> repairs = searchService.
                            searchRepairByPlate(paramsMap.get("userPlate"));
                    if(!repairs.isEmpty()) {
                        redirectAttributes.addFlashAttribute("repairs",repairs);
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
    }// end of handleVehicleSearch()

}
