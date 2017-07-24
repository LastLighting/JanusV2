package topprogersgroup.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import topprogersgroup.entity.Owner;

/**
 * Created by VP on 15.06.2017.
 */

@Component
public class OwnerValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Owner.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Owner owner = (Owner)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "documentNumber", "error.documentNumber", "Document Number is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstName", "First name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName", "Last name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "middlename", "error.middlename", "Middle name is required.");
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phonenumber", "error.phonenumber", "Phone number is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.address", "Address is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName", "Last name is required.");
    }
}