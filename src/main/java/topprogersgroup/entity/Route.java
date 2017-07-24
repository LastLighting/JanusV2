package topprogersgroup.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

// маршрут
@Data
@Entity
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    // пункт назначения
    @Column(name = "destination", nullable = false)
    private String destination;

    // пункт отправления
    @Column(name = "departure", nullable = false)
    private String departure;

    // пукты следования
    @Column(name = "followingPoints", nullable = false, length = 255)
    private String followingPoints;

    // въездной БИП в ЕС
    @Column(name = "borderInspectionPosts", nullable = false)
    private String BorderInspectionPosts;

    @Column(name = "transportType", nullable = false)
    private String transportType;

    @Column(name = "transportID", nullable = false)
    private String transportID;

    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
    Set<CheckPoint> checkPoints;

    @Column(name = "isdeleted")
    @Type(type = "boolean")
    private boolean isDeleted;
}
