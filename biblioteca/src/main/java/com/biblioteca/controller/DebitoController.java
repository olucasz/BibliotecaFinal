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

import com.biblioteca.model.Debito;
import com.biblioteca.repository.DebitoRepository;

@RestController
@RequestMapping("/debito")
public class DebitoController {

    @Autowired
    private DebitoRepository debitoRepository; ;

    //criar um novo debito
    @PostMapping
    public ResponseEntity<Debito> save(@RequestBody Debito debito) {
        return ResponseEntity.ok(debitoRepository.save(debito));
    }

    //buscar debitos por matricula
    @GetMapping("/{matricula}")
    public ResponseEntity<List<Debito>> findByDebitos(@PathVariable String matricula) {
        return ResponseEntity.ok(debitoRepository.findByDebitos(matricula));
    }

    //listar por id
    @GetMapping("/id/{id}")
    public ResponseEntity<Debito> findById(@PathVariable Long id) {
        return ResponseEntity.ok(debitoRepository.findById(id));
    }

    //listar todos os debitos
    @GetMapping
    public ResponseEntity<List<Debito>> findAll() {
        return ResponseEntity.ok(debitoRepository.findAll());
    }

    //verificar se o aluno possui debitos
    public boolean verificarDebito(String matricula) {
        return debitoRepository.verificarDebito(matricula);
    }
}
