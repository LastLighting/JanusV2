package topprogersgroup.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class RegistrationForm {

    @NotEmpty
    private String email = "";

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String passwordRepeated = "";

    @NotEmpty
    private String documentNumber;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String middleName;

    @NotEmpty
    private Date birthDate;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String address;

    @NotNull
    private Role role = Role.PET_OWNER;
}
