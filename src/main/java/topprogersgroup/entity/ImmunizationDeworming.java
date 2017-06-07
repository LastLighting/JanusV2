package topprogersgroup.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "immunizationDeworming")
public class ImmunizationDeworming {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "immunizationDeworming", nullable = false)
    private boolean immunizationDeworming;

    @Column(name = "date", nullable = false)
    @Temporal(value=TemporalType.DATE)
    private Date date;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "drug", nullable = false)
    private String drug;

    @ManyToOne
    @JoinColumn(name = "id_passport")
    private Passport passport;
}
