package topprogersgroup.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "route")
    private Route route;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pet_bid", joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "bid_id"))
    private List<Pet> pets;

    @Column(name = "isdeleted")
    @Type(type = "boolean")
    private boolean isDeleted;
}