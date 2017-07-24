package topprogersgroup.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

//ветеринарный сертификат
@Data
@Entity
@Table(name = "veterinarycertificate")
public class VeterinaryCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    // дата оформления сертификата
    @Column(name = "issueDate", nullable = false)
    private Date issueDate;

    // местный компетентный орган
    @Column(name = "localcompetentauthority", nullable = false)
    private String localCompetentAuthority;

    // цетральный компетентный орган
    @Column(name = "centralCompetentAuthority", nullable = false)
    private String centralCompetentAuthority;

    // место оформления
    @Column(name = "registrationplace", nullable = false)
    private String registrationPlace;

    @Column(name = "number", nullable = false, unique = true)
    private int number;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "veterinarydocument", nullable = false)
    private VeterinaryDocument veterinaryDocument;

    @Column(name = "isdeleted")
    @Type(type = "boolean")
    private boolean isDeleted;
}
