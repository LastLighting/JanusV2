package topprogersgroup.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import topprogersgroup.entity.ImmunizationDeworming;

/**
 * Created by VP on 15.06.2017.
 */

@Component
public class ImmunizationDewormingValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(ImmunizationDeworming.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ImmunizationDeworming deworming = (ImmunizationDeworming)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "imName", "error.imName", "Im name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "drug", "error.drug", "Лекарство обязательное поле.");
        if(deworming.getDate() == null){
//            errors.rejectValue(field, errorCode, errorArgs, defaultMessage);
            errors.rejectValue("date","errors.date", "Дата не введена");
        }
    }
}
