package topprogersgroup.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import topprogersgroup.entity.Passport;

/**
 * Created by VP on 15.06.2017.
 */
public class PassportValidation implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Passport.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Passport passport = (Passport) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "animalType", "error.animalType", "Тип петомца обязательное поле.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "petName", "error.petName", "Кличка обязательное поле.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "breed", "error.breed", "Порода обязательное поле.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "color", "error.color", "Окрас обязательное поле.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clinic", "error.clinic", "Серия вакцины обязательное поле.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "doctor", "error.doctor", "Серия вакцины обязательное поле.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberMicrochipTattoo", "error.seriesOfVaccine", "Номер чипа/тату обязательное поле.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "offspring", "error.offspring", "Серия вакцины обязательное поле.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "specialFeatures", "error.specialFeatures", "Серия вакцины обязательное поле.");
        if(passport.getDateOfBirth() == null){
            errors.rejectValue("dateOfBirth","errors.dateOfBirth", "Дата не введена");
        }
        if(passport.getDateOfImplantation() == null){
            errors.rejectValue("dateOfImplantation","errors.dateOfImplantation", "Дата не введена");
        }
    }
}


