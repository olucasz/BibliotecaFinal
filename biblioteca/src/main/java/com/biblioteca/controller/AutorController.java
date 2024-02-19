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

import com.biblioteca.repository.AutorRepository;
import com.biblioteca.model.Autor;

@RestController
@RequestMapping("/autor")
public class AutorController {
    
    //Requisições http
    @Autowired
    private AutorRepository repository;

    @PostMapping
    public ResponseEntity<Autor> cadastrarAutor(@RequestBody Autor autor) {
        return ResponseEntity.ok(repository.save(autor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> listarPorId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(repository.findById(id));
    }
    
    @GetMapping
    public ResponseEntity<List<Autor>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }
}
