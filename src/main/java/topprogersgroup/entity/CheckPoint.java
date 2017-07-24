package topprogersgroup.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// пропускной пунк (ПКВП)
@Data
@Entity
@Table(name = "checkpoint")
public class CheckPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String cpName;

    @Column(name = "address", nullable = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String address;

    @Column(name = "phonenumber", nullable = false)
    @NotNull
    @Size(min = 1, max = 12)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "inspector")
    private Employee inspector;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "route_checkpoint",
            joinColumns = @JoinColumn(name = "checkPoint_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id"))
    private Route route;

    @Column(name = "isdeleted")
    @Type(type = "boolean")
    private boolean isDeleted;
}
