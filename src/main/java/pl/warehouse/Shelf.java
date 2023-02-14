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

    //Wiele półek może mieć jeden regał
    @ManyToOne
    Rack rack;

    //Jedna część może mieć jedno miejsce w magazynie
    @OneToOne(mappedBy = "shelf")
    Part part;

}
