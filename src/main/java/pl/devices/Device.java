package pl.devices;

import pl.malfunctions.Malfunction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long name;

//    Wiele urzadzen może mieć wiele awarii
    @ManyToMany(mappedBy = "devices")
    List<Malfunction> malfunctions;
}
