package pl.warehouse;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "racks")
public class Rack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String rackNumber;

    //Jeden regał może mieć wiele półek
    @OneToMany(mappedBy = "rack")
    List<Shelf> shelfList;



}
