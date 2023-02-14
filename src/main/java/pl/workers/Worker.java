package pl.workers;

import pl.malfunctions.Malfunction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;

    //Wiele awarii może mieć wiele pracowników
    @ManyToMany(mappedBy = "workers")
    List<Malfunction> malfunctions;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
