package topprogersgroup.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "vaccination")
public class Vaccination {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "dateOfVaccine", nullable = false)
    @Temporal(value=TemporalType.DATE)
    private Date dateOfVaccine;

    @Column(name = "typeOfVaccine", nullable = false)
    private String typeOfVaccine;

    @Column(name = "seriesOfVaccine", nullable = false)
    private String seriesOfVaccine;

    @Column(name = "validUntil", nullable = false)
    private Date validUntil;

    @ManyToOne
    @JoinColumn(name = "id_passport")
    private Passport passport;
}
