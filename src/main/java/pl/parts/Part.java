package pl.parts;

import pl.malfunctions.Malfunction;
import pl.warehouse.Shelf;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parts")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    private int quantity;


    //Wiele części może mieć jedną kategorie
    @ManyToOne
    Category category;

    //Wiele części może być użyte w wielu awariach

    @ManyToMany(mappedBy = "parts")
    List<Malfunction> malfunctions;

    //Jedna część może mieć jedno miejsce w magazynie
    @OneToOne
    Shelf shelf;



}
