package pl.malfunctions;

import pl.devices.Device;
import pl.parts.Part;
import pl.workers.Worker;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "malfunctions")
public class Malfunction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    //Wiele awarii może mieć wiele pracowników
    @ManyToMany
    List<Worker> workers;

    //Wiele awarii może mieć wiele części
    @ManyToMany
    List<Part> parts;

    //Wiele awarii może mieć wiele urządzen
    @ManyToMany
    List<Device> devices;




    public long getId() {
        return id;
    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
