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

    private String description;

    //Jeden zgłaszający może mieć wiele awarii
    @OneToMany(mappedBy = "worker")
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

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Malfunction> getMalfunctions() {
        return malfunctions;
    }

    public void setMalfunctions(List<Malfunction> malfunctions) {
        this.malfunctions = malfunctions;
    }


}
