package topprogersgroup.validator;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Component
public class FileValidator implements Validator {

    private final String[] allowedTypes = {"image/bmp", "image/jpeg", "image/tiff", "image/png"};

    public boolean supports(Class<?> aClass) {
        return aClass.equals(MultipartFile.class);
    }

    public void validate(Object o, Errors errors) {
        MultipartFile file = (MultipartFile) o;
        if(file.isEmpty()) {
            errors.rejectValue("file.empty", "Файл не выбран");
        }
        if (Arrays.asList(allowedTypes).contains(file.getContentType())) {
            errors.rejectValue("file.notValidType", "Недопустимый тип файла. Загрузите png, jpeg, bmp, tiff");
        }
    }
}
