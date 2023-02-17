package pl.malfunctions;

import pl.parts.Part;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "malfunction-parts")
public class MalfunctionParts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int quantity;

    @OneToMany
    List<Part> parts;
}
