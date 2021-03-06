package com.rgcs_motors.RGCS_Service_Management.validators;

import com.rgcs_motors.RGCS_Service_Management.model.SearchForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class SearchFormValidator implements Validator{

    private enum UserMessages{
        OVERSIZED,
        IVALID_EMAIL,
        IVALID_VAT
    }

    private enum VehicleMessages{
        OVERSIZED_V,
        IVALID_PLATE,
        IVALID_VAT_V
    }


    private Map<String,String> searchParamsMap = new HashMap<>();


    @Override
    public boolean supports(Class<?> aClass) {
        return SearchFormValidator.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        System.out.println("\nwe are in validate");
        SearchForm form = (SearchForm) o;
        String messageFromFiltering = filterSearchParams(form);
        showAppropriateErrorMessage(messageFromFiltering, errors);
    }

    private void showAppropriateErrorMessage(String message, Errors errors)
    {
        System.out.println("\nwe are in showAppropriateErrorMessage");
        switch(message){
            case "OVERSIZED":
                errors.rejectValue("searchval","You have entered too many parameters");
                break;
            case "IVALID_EMAIL":
                errors.rejectValue("searchval","The email you entered is invalid");
                break;
            case "IVALID_VAT":
                errors.rejectValue("searchval","The vat number you entered is invalid");
                break;
            case "OVERSIZED_V":
                errors.rejectValue("searchval","You have entered too many parameters");
                break;
            case "IVALID_PLATE":
                errors.rejectValue("searchval","The plate you entered is invalid");
                break;
            case "IVALID_VAT_V":
                errors.rejectValue("searchval","The vat number you entered is invalid");
                break;
            case "EMPTY_TYPE":
                errors.rejectValue("searchtype","You must select target to check");
                break;
        }
    }

    private String filterSearchParams(Object o)
    {
        System.out.println("\nwe are in filterSearchParams");
        String message = "";
        SearchForm form = (SearchForm) o;
        switch(form.getSearchtype())
        {
            case "Owner":
                message = filterOwner(form);
            break;
            case "Vehicle":
                message = filterVehicle(form);
                break;
            case "Repair":
                message = filterRepair(form);
                break;
            default:
                message = "EMPTY_TYPE";
                break;
        }
        return message;
    }


    private String filterOwner(SearchForm form)
    {
        System.out.println("\nwe are in filterOwner");
        String[] searchParams = form.getSearchval().trim().split(",");
        System.out.println("validator form search params : " + searchParams[0]);
        String vat = "";
        String message = "";
        if(searchParams.length >= 3) {  //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> search input is too many values
            message = UserMessages.OVERSIZED.toString();
        }
        else if(searchParams.length == 2) { //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> search input is two values
            if(searchParams[0].contains("@") &&
                    searchParams[0].indexOf(".") > searchParams[0].indexOf("@"))// if mail is correct
            {
                vat = searchParams[1];
                if(vat.length() != 9 || !vat.matches("^[1-9]{9}$"))
                {
                    message = UserMessages.IVALID_VAT.toString();
                }
                else{
                    searchParamsMap.put("userMail",searchParams[0]);
                    searchParamsMap.put("userVat",searchParams[1]);
                }
            }
            else if(searchParams[1].contains("@") &&
                    searchParams[1].indexOf(".") > searchParams[1].indexOf("@"))
            {
                vat = searchParams[0];
                if(vat.length() != 9 || !vat.matches("^[1-9]{9}$"))
                {
                    message = UserMessages.IVALID_VAT.toString();
                }
                else{
                    searchParamsMap.put("userMail",searchParams[1]);
                    searchParamsMap.put("userVat",searchParams[0]);
                }
            }
            else
                message = UserMessages.IVALID_EMAIL.toString();
        }
        else if(searchParams.length == 1) //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> search input is one value
        {
            if(!searchParams[0].contains("@"))
            {
                vat = searchParams[0];
                System.out.println("[validator] vat" + vat);
                if(!(vat.length() == 9 && vat.matches("^[1-9]{9}$")))
                {
                    System.out.println("ivalid vat");
                    message = UserMessages.IVALID_VAT.toString();
                }
                else{
                    System.out.println("[validator] vat was put i search params");
                    searchParamsMap.put("userVat",searchParams[0]);
                }
            }
            else if(searchParams[0].contains("@") &&
                    searchParams[0].indexOf(".") < searchParams[0].indexOf("@")) {
                message = UserMessages.IVALID_EMAIL.toString();
            }
            else {
                System.out.println("[validator] mail was put i search params");
                searchParamsMap.put("userMail",searchParams[0]);
            }
        }
        return message;
    }

    private String filterVehicle(SearchForm form)
    {
        System.out.println("\nwe are in filterVehicle");
        String[] searchParams = form.getSearchval().trim().split(",");
        System.out.println("validator form search params : " + searchParams[0]);
        String vat = "";
        String message = "";
        if(searchParams.length >= 3) {  //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> search input is too many values
            message = UserMessages.OVERSIZED.toString();
        }
        else if(searchParams.length == 2) { //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> search input is two values
            if(searchParams[0].matches("[a-zA-Z]{3}-[0-9]{4}"))// if plate is correct
            {
                vat = searchParams[1];
                if(vat.length() != 9 || !vat.matches("^[1-9]{9}$"))
                {
                    message = VehicleMessages.IVALID_VAT_V.toString();
                }
                else{
                    searchParamsMap.put("userPlate",searchParams[0]);
                    searchParamsMap.put("userVat",searchParams[1]);
                }
            }
            else if(searchParams[1].matches("[a-zA-Z]{3}-[0-9]{4}"))
            {
                vat = searchParams[0];
                if(vat.length() != 9 || !vat.matches("^[1-9]{9}$"))
                {
                    message = VehicleMessages.IVALID_VAT_V.toString();
                }
                else{
                    searchParamsMap.put("userPlate",searchParams[1]);
                    searchParamsMap.put("userVat",searchParams[0]);
                }
            }
            else
                message = VehicleMessages.IVALID_PLATE.toString();
        }
        else if(searchParams.length == 1) //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> search input is one value
        {
            if(!searchParams[0].matches("[a-zA-Z]{3}-[0-9]{4}"))
            {
                vat = searchParams[0];
                System.out.println("[validator] vat" + vat);
                if(!(vat.length() == 9 && vat.matches("^[1-9]{9}$")))
                {
                    System.out.println("ivalid vat");
                    message = VehicleMessages.IVALID_VAT_V.toString();
                }
                else{
                    System.out.println("[validator] vat was put i search params");
                    searchParamsMap.put("userVat",searchParams[0]);
                }
            }
            else {
                System.out.println("[validator] plate was put i search params");
                searchParamsMap.put("userPlate",searchParams[0]);
            }
        }
        return message;
    }


    private String filterRepair(SearchForm form)
    {
        System.out.println("\nwe are in filterRepair");
        String[] searchParams = form.getSearchval().trim().split(",");
        System.out.println("validator form search params : " + searchParams[0]);
        String vat = "";
        String message = "";
        if(searchParams.length >= 2) {  //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> search input is too many values
            message = UserMessages.OVERSIZED.toString();
        }
        else if(searchParams.length == 1) //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> search input is one value
        {
            if(!searchParams[0].matches("[a-zA-Z]{3}-[0-9]{4}"))
                {
                vat = searchParams[0];
                System.out.println("[validator] vat" + vat);
                if(!vat.matches("^[1-9]{9}$"))
                {
                    System.out.println("ivalid vat");
                    message = VehicleMessages.IVALID_VAT_V.toString();
                }
                else{
                    System.out.println("[validator] vat was put i search params");
                    searchParamsMap.put("userVat",searchParams[0]);
                }
            }
            else {
                System.out.println("[validator] plate was put i search params");
                searchParamsMap.put("userPlate",searchParams[0]);
            }
        }
        return message;
    }


    public Map<String, String> getSearchParamsMap() {
        return searchParamsMap;
    }

    public String clearSearchParamsMap() {
        searchParamsMap.clear();
        return "cleared";
    }
}
