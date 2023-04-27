package mk.ukim.finki.emtlab.web.rest;


import mk.ukim.finki.emtlab.model.Country;
import mk.ukim.finki.emtlab.model.dto.CountryDto;
import mk.ukim.finki.emtlab.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/countries")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    //LIST OF COUNTRIES
    @GetMapping
    public List<Country> findAll(){
        return this.countryService.findAll();
    }


    //GET COUNTRY WITH ID
    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id){
        return this.countryService.findById(id)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //ADD A COUNTRY
    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestBody CountryDto countryDto){
        return this.countryService.save(countryDto)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    //EDIT A COUNTRY
    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> edit(@PathVariable Long id, @RequestBody CountryDto countryDto){
        return this.countryService.edit(id, countryDto)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    //DELETE A COUNTRY
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Country> deleteById(@PathVariable Long id){
        this.countryService.deleteById(id);
        if(this.countryService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();

    }


}
