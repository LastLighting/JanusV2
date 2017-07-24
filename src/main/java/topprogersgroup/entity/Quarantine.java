package topprogersgroup.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "quarantine")
public class Quarantine {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "laboratory", nullable = false)
    private String laboratory;

    @Column(name = "numberOfDays", nullable = false)
    private int numberOfDays;

    @Column(name = "addressLaboratory")
    private String addressOfLaboratory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quarantine")
    private List<Disease> diseases;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "quarantine", fetch = FetchType.EAGER)
    private Pet pet;

    @Column(name = "isdeleted")
    @Type(type = "boolean")
    private boolean isDeleted;
}
