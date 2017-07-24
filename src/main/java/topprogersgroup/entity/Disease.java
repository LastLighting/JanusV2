package topprogersgroup.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "disease")
public class Disease {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String disName;

    @Column(name = "dateresearch", nullable = false)
    @Temporal(value= TemporalType.DATE)
    private Date dateResearch;

    @Column(name = "researchmethod", nullable = false)
    private String researchMethod;

    @Column(name = "result", nullable = false)
    private String result;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "quarantine_id")
    private Quarantine quarantine;

}
