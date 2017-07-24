package topprogersgroup.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

// ветеринарное свидетельство
@Data
@Entity
@Table(name = "veterinarydocument")
public class VeterinaryDocument{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    // время пребывания животного в РФ
    @Column(name = "residencetime", nullable = false)
    private int residenceTime;

    // дата оформления свидетельства
    @Column(name = "issueDate", nullable = false)
    private Date issueDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "stateveterinaryservice", nullable = false)
    private StateVeterinaryService stateVeterinaryService;

    // заявка на вывоз
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bid", nullable = false)
    private Bid bid;

    // номер свидетельства
    @Column(name = "number", nullable = false, unique = true)
    private int number;

    @OneToMany(mappedBy = "veterinaryDocument", cascade = CascadeType.ALL)
    private List<SpecialNotes> specialNotes;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee", nullable = false)
    private Employee employee;

    // изначально задаваемый статус
    @Column(name = "status")
    private String status;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "veterinaryDocument")
    private VeterinaryCertificate veterinaryCertificate;

    @Column(name = "isdeleted")
    @Type(type = "boolean")
    private boolean isDeleted;
}
