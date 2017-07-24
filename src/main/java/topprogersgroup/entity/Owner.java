package topprogersgroup.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "documentnumber", unique = true, nullable = false)
    @NotNull
    @Size(min = 2, max = 30, message = "")
    private String documentNumber;

    @Column(name = "firstname", nullable = false)
    @NotNull
    @Size(min = 2, max = 30, message = "")
    private String firstName;

    @Column(name = "lastname", nullable = false)
    @NotNull
    @Size(min = 2, max = 30, message = "")
    private String lastName;

    @Column(name = "middlename", nullable = false)
    @NotNull
    @Size(min = 2, max = 30, message = "")
    private String middleName;

    @Column(name = "birthdate", nullable = false)
    @Temporal(value=TemporalType.DATE)
//    @NotNull
    private Date birthdate;

    @Column(name = "phonenumber")
    @NotNull
    @Size(min = 4, max = 11, message = "")
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    @NotNull
    @Size(min = 2, max = 255, message = "")
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Passport> passport;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pet> pet;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "isdeleted")
    @Type(type = "boolean")
    private boolean isDeleted;
}
