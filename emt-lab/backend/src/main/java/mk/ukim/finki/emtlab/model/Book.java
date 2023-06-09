package mk.ukim.finki.emtlab.model;


import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.emtlab.model.enumerations.Category;

@Data
@Entity
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer availableCopies;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Author author;


    public Book(){

    }

    public Book(String name, Integer availableCopies, Category category, Author author) {
        this.name = name;
        this.availableCopies = availableCopies;
        this.category = category;
        this.author = author;
    }
}