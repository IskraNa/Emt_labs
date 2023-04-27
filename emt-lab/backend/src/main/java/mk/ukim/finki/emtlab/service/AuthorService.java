package mk.ukim.finki.emtlab.service;

import mk.ukim.finki.emtlab.model.Author;
import mk.ukim.finki.emtlab.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> save(String name, String surname, Long countryId);

    Optional<Author> save(AuthorDto authorDto);

    Optional<Author> edit(Long id, String name, String surname, Long countryId);

    Optional<Author> edit(Long id, AuthorDto authorDto);

    void deleteById(Long id);
}