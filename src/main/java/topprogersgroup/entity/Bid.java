package topprogersgroup.entity;

import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

//Заявка
@Data
@Entity
@Table(name = "bid")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    //Дата отправления
    @Column(name = "departuredate", nullable = false)
    private Date departureDate;

    @Column(name = "countpet", nullable = false)
    private int countPet;

    @Column(name = "countseats", nullable = false)
    private int countSeats;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "route")
    private Route route;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "pet_bid", joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "bid_id"))
    private List<Pet> pets;

    @OneToOne(mappedBy = "bid")
    private VeterinaryDocument veterinaryDocument;

    @Column(name = "isdeleted")
    @Type(type = "boolean")
    private boolean isDeleted;

}
