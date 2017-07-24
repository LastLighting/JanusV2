package topprogersgroup.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "administrator")
public class Administrator {

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user", unique = true)
    private User user;

    @Column(name = "isdeleted")
    @Type(type = "boolean")
    private boolean isDeleted;
}

