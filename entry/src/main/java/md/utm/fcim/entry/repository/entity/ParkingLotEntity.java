package md.utm.fcim.entry.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "parking_lot")
@Getter
@Setter
public class ParkingLotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "place")
    private Integer place;

    @Column(name = "counter")
    private Integer counter;
}
