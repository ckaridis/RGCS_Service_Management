package com.rgcs_motors.RGCS_Service_Management.validators;

import com.rgcs_motors.RGCS_Service_Management.model.SearchForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SearchFormValidator implements Validator{

    private enum UserMessages{
        OVERSIZED,
        IVALID_EMAIL,
        IVALID_VAT
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return SearchFormValidator.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SearchForm form = (SearchForm) o;
    }

    private String filterSearchParams(Object o)
    {
        String message = "";
        SearchForm form = (SearchForm) o;
        switch(form.getSearchtype())
        {
            case "Owner":
                message = filterOwner(form);
            break;
        }
        return message;
    }


    private String filterOwner(SearchForm form)
    {
        String[] searchParams = form.getSearchval().trim().split(",");
        String vat = "";
        String message = "";
        if(searchParams.length >= 3) {  //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> search input is too many values
            message = UserMessages.OVERSIZED.toString();
        }
        else if(searchParams.length == 2) { //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> search input is two values
            if(searchParams[0].contains("@") &&
                    searchParams[0].indexOf(".") > searchParams[0].indexOf("@"))
            {
                vat = searchParams[1];
                if(vat.length() != 9 || !vat.matches("^[1-9]{9}$"))
                {
                    message = UserMessages.IVALID_VAT.toString();
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
            }
            else
                message = UserMessages.IVALID_EMAIL.toString();
        }
        else if(searchParams.length == 1) //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> search input is one value
        {
            if(!searchParams[0].contains("@"))
            {
                vat = searchParams[0];
                if(vat.length() != 9 || !vat.matches("^[1-9]{9}$"))
                {
                    message = UserMessages.IVALID_VAT.toString();
                }
            }
            else if(searchParams[0].indexOf(".") < searchParams[0].indexOf("@")) {
                message = UserMessages.IVALID_EMAIL.toString();
            }

        }
        return message;
    }
}
