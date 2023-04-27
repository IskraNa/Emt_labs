package mk.ukim.finki.emtlab.web.rest;


import mk.ukim.finki.emtlab.model.Author;
import mk.ukim.finki.emtlab.model.dto.AuthorDto;
import mk.ukim.finki.emtlab.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final AuthorService authorService;


    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //LIST OF AUTHORS
    @GetMapping
    public List<Author> findAll(){
        return this.authorService.findAll();
    }

    //GET AUTHOR WITH ID
    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id){
        return this.authorService.findById(id)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //ADD AN AUTHOR
    @PostMapping("/add")
    public ResponseEntity<Author> save(@RequestBody AuthorDto authorDto){
        return this.authorService.save(authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    //EDIT AN AUTHOR
    @PutMapping("/edit/{id}")
    public ResponseEntity<Author> edit(@PathVariable Long id, @RequestBody AuthorDto authorDto){
        return this.authorService.edit(id, authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    //DELETE AN AUTHOR
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Author> deleteById(@PathVariable Long id){
        this.authorService.deleteById(id);
        if(this.authorService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();

    }
}

