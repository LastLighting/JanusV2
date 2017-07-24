package topprogersgroup.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//ГосВетСлужба
@Data
@Entity
@Table(name = "stateveterinaryservice")
public class StateVeterinaryService {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    @NotNull
    @Size(min = 1, max = 255)
    private String serviceName;

    @Column(name = "address")
    @NotNull
    @Size(min = 1, max = 255)
    private String address;

    @Column(name = "isdeleted")
    @Type(type = "boolean")
    private boolean isDeleted;
}
