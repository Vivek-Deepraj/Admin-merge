package com.discom.springmvc.validator;


import com.discom.springmvc.dao.ListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("formValidator")
public class FormValidator implements Validator {

    @Autowired
    private ListDao listDao;

    @SuppressWarnings("unchecked")
    @Override
    public boolean supports(Class clazz) {
        return true;
    }

    public boolean isDigit(String str) {
        int x;
        for (int j = 0; j < str.length(); j++) {
            x = (int) str.charAt(j);
            if (x < 48 || x > 57) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void validate(Object model, Errors errors) {
        System.out.println("shggjghj");
        // ValidationUtils.rejectIfEmptyOrWhitespace(errors,
        // "name","required.name", "Name is required.");

        /**
         * Validation For Added And Edit New Company
         */
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailID",
                "required.emailID", "Email ID is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "compName",
                "required.compName", "Company Name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "keyPerson",
                "required.keyPerson", "key Person is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designation",
                "required.designation", "Designation is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address",
                "required.address", "Address is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip",
                "required.zip", "Zip is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city",
                "required.city", "City is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state",
                "required.state", "State is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country",
                "required.country", "Country is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tele1",
                "required.tele1", "Phone is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cell",
                "required.cell", "Cell is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fax",
                "required.fax", "Fax is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tele1",
                "required.tele1", "Phone is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Website",
                "required.Website", "Website is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tele3",
                "required.tele3", "Password is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
                "required.confirmPassword", "Confirm Password is required.");
    }
}
