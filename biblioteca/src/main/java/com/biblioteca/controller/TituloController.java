package com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.model.Autor;
import com.biblioteca.model.Titulo;
import com.biblioteca.repository.AutorRepository;
import com.biblioteca.repository.TituloRepository;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/titulo")
public class TituloController {
    
    //Requisições http
    @Autowired
    private TituloRepository tituloRepository;
    @Autowired
    private AutorRepository autorRepository;
    @PostMapping
    public ResponseEntity<Titulo> criarTitulo(@RequestBody Titulo titulo) {
        return ResponseEntity.ok(tituloRepository.save(titulo));
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Titulo> findByIsbn(@PathVariable(value = "isbn") String isbn) {
        return ResponseEntity.ok(tituloRepository.findByIsbn(isbn));
    }
    @GetMapping
    public ResponseEntity<List<Titulo>> findAll() {
        return ResponseEntity.ok(tituloRepository.findAll());
    }

    @PutMapping("/{isbn}/autor/{id}")
    public ResponseEntity<Titulo> adicionarAutor(
        @PathVariable(value = "isbn") String isbn, 
        @PathVariable(value = "id") Long id) {
        Titulo titulo = tituloRepository.findByIsbn(isbn);
        System.out.println(titulo);
        Autor autor = autorRepository.findById(id);
        System.out.println(autor);
        titulo.getAutores().add(autor);
        return ResponseEntity.ok(tituloRepository.save(titulo));
    }

    public Integer verPrazo(String isbn){
        Titulo titulo = tituloRepository.findByIsbn(isbn);
        return titulo.getPrazo();
    }

}
