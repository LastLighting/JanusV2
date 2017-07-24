package topprogersgroup.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "specialnotes")
public class SpecialNotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    // особые условия перевозки
    @Column(name = "conditionscarriage")
    private String specialConditionsCarriage;

    // дата получения особых отметок
    @Column(name = "datenotes")
    private Date dateNotes;

    // отметки об осмотре
    @Column(name = "inspectionnotes")
    private String inspectionNotes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "veterinarydocument")
    private VeterinaryDocument veterinaryDocument;

    @Column(name = "isdeleted")
    @Type(type = "boolean")
    private boolean isDeleted;
}
