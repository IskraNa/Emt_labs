package mk.ukim.finki.emtlab.model.dto;

import lombok.Data;
import mk.ukim.finki.emtlab.model.enumerations.Category;

@Data
public class BookDto {

    private String name;

    private Integer availableCopies;

    private Category category;

    private Long author;

    public BookDto(String name, Integer availableCopies, Category category, Long author) {
        this.name = name;
        this.availableCopies = availableCopies;
        this.category = category;
        this.author = author;
    }
}