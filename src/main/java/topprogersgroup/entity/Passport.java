package topprogersgroup.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@ToString
@Table(name = "passport")
public class Passport {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "guid", nullable = false)
    private String guid;

    @Column(name = "isLast")
    @Type(type = "boolean")
    private boolean isLast;

    @Column(name = "animaltype", nullable = false)
    private String animalType;

    @Column(name = "petname", nullable = false)
    private String petName;

    //пол
    @Column(name = "gender", nullable = false)
    private boolean gender;

    //порода
    @Column(name = "breed", nullable = false)
    private String breed;

    @Column(name = "color", nullable = false)
    private String color;

    //особые приметы
    @Column(name = "specialFeatures")
    private String specialFeatures;

    @Column(name = "dateOfBirth", nullable = false)
    @Temporal(value=TemporalType.DATE)
    private Date dateOfBirth;

    //потомство
    @Column(name = "offspring")
    private String offspring;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    //Иммунизация-Дегельминтизация
    @OneToMany(mappedBy = "passport", cascade = CascadeType.ALL)
    private List<ImmunizationDeworming> immunizationDeworming;

    @Column(name = "castrationSterilization")
    private boolean castrationSterilization;

    @Column(name = "clinic", nullable = false)
    private String clinic;

    @Column(name = "doctor", nullable = false)
    private String doctor;

    @Column(name = "microchipTattoo", nullable = false)
    private boolean microchipTattoo;

    @Column(name = "numberMicrochipTattoo", nullable = false)
    private String numberMicrochipTattoo;

    @Column(name = "dateOfImplantation", nullable = false)
    @Temporal(value=TemporalType.DATE)
    private Date dateOfImplantation;

    @OneToMany(mappedBy = "passport", cascade = CascadeType.ALL)
    private List<Vaccination> vaccination;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "passport", fetch = FetchType.EAGER)
    private Pet pet;

    @OneToMany(mappedBy = "passport")
    private List<UploadImage> images;

    @Column(name = "isdeleted")
    @Type(type = "boolean")
    private boolean isDeleted;
}
