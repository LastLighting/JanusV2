package topprogersgroup.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "firstname", nullable = false)
    @NotNull
    @Size(min = 1, max = 55)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    @NotNull
    @Size(min = 1, max = 55)
    private String lastName;

    @Column(name = "middlename", nullable = false)
    @NotNull
    @Size(min = 1, max = 55)
    private String middleName;

    @Column(name = "documentnumber", nullable = false, unique = true)
    @Max(99999999999L)
    private long documentNumber;

    @Column(name = "phonenumber", nullable = false, unique = true)
    @NotNull
    @Size(min = 1, max = 25)
    private String phoneNumber;

    // адрес проживания
    @Column(name = "residentialaddress", nullable = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String residentialAddress;

    // место работы (ГосВетСлужба)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "veterinaryservice")
    private StateVeterinaryService stateVeterinaryService;

    // дата приёма на работу
    @Column(name = "employmentdate", nullable = false)
    @Temporal(value=TemporalType.DATE)
    private Date employmentDate;

    // должность
    @Column(name = "position", nullable = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String position;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user", unique = true)
    private User user;

    @Column(name = "isdeleted")
    @Type(type = "boolean")
    private boolean isDeleted;
}
