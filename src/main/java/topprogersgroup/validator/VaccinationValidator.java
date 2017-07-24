package topprogersgroup.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import topprogersgroup.entity.Vaccination;

/**
 * Created by VP on 15.06.2017.
 */
public class VaccinationValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Vaccination.class);
    }
    //errors.rejectValue(field, errorCode, errorArgs, defaultMessage);
    @Override
    public void validate(Object o, Errors errors) {
        Vaccination vaccination = (Vaccination)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "seriesOfVaccine", "error.seriesOfVaccine", "Серия вакцины обязательное поле.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "typeOfVaccine", "error.typeOfVaccine", "Тип вакцины обязательное поле.");
        if(vaccination.getDateOfVaccine() == null){
            errors.rejectValue("dateOfVaccine","errors.dateOfVaccine", "Дата не введена");
        }
        if(vaccination.getValidUntil() == null){
            errors.rejectValue("validUntil","errors.validUntil", "Дата не введена");
        }
    }
}
