package topprogersgroup.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "immunizationdeworming")
public class ImmunizationDeworming {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "immunizationdeworming", nullable = false)
    private boolean immunizationDeworming;

    @Column(name = "date", nullable = false)
    @Temporal(value=TemporalType.DATE)
    private Date date;

    @Column(name = "name", nullable = false)
    private String imName;

    @Column(name = "drug", nullable = false)
    private String drug;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_passport")
    private Passport passport;

}
