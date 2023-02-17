package pl.warehouse;

import pl.parts.Part;

import javax.persistence.*;

@Entity
@Table(name = "shelfs")
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String shelf;

    //Jedna część może mieć jedno miejsce w magazynie
    @OneToOne(mappedBy = "shelf")
    Part part;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }


    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    


}
