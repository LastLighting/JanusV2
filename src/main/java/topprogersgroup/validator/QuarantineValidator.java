package topprogersgroup.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import topprogersgroup.entity.Quarantine;

/**
 * Created by VP on 15.06.2017.
 */
public class QuarantineValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Quarantine.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Quarantine quarantine = (Quarantine)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "laboratory", "error.laboratory", "Лаборатория обязательное поле.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressOfLaboratory", "error.addressOfLaboratory", "Адрес лаборатории обязательное поле.");
        if(quarantine.getNumberOfDays()<0){
            errors.rejectValue("numberOfDays","error.numberOfDays","Кол-во дней должно быть больше нуля");
        }
    }
}
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quarantine")
//    private List<Disease> diseases;
