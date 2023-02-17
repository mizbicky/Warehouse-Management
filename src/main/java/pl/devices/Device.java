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
    private String name;

//    Wiele urzadzen może mieć wiele awarii
    @OneToMany(mappedBy = "device")
    List<Malfunction> malfunctions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Malfunction> getMalfunctions() {
        return malfunctions;
    }

    public void setMalfunctions(List<Malfunction> malfunctions) {
        this.malfunctions = malfunctions;
    }


}


