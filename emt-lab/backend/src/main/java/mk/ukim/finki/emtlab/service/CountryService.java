package mk.ukim.finki.emtlab.service;


import mk.ukim.finki.emtlab.model.Country;
import mk.ukim.finki.emtlab.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(String name, String continent);

    Optional<Country> save(CountryDto countryDto);

    Optional<Country> edit(Long id, String name, String continent);

    Optional<Country> edit(Long id, CountryDto countryDto);

    void deleteById(Long id);
}