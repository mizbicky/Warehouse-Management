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

    private String description;

    private int minQuantity;


    //Wiele części może mieć jedną kategorie
    @ManyToOne
    Category category;

    //Wiele części może być użyte w wielu awariach

    @ManyToMany(mappedBy = "parts")
    List<Malfunction> malfunctions;

    //Jedna część może mieć jedno miejsce w magazynie
    @OneToOne
    Shelf shelf;


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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Malfunction> getMalfunctions() {
        return malfunctions;
    }

    public void setMalfunctions(List<Malfunction> malfunctions) {
        this.malfunctions = malfunctions;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", minQuantity=" + minQuantity +
                ", category=" + category +
                ", malfunctions=" + malfunctions +
                ", shelf=" + shelf +
                '}';
    }
}
