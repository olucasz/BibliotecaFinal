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

import com.biblioteca.model.ItemEmprestimo;
import com.biblioteca.repository.ItemEmprestimoRepository;

@RestController
@RequestMapping("/itemEmprestimo")
public class ItemEmprestimoController {
    @Autowired
    private ItemEmprestimoRepository itemEmprestimoRepository;

    @PostMapping
    public ResponseEntity<ItemEmprestimo> criarItemEmprestimo(@RequestBody ItemEmprestimo itemEmprestimo) {
        return ResponseEntity.ok(itemEmprestimoRepository.save(itemEmprestimo));
    }

    @GetMapping
    public ResponseEntity<List<ItemEmprestimo>> findAll() {
        return ResponseEntity.ok(itemEmprestimoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemEmprestimo> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(itemEmprestimoRepository.findById(id));
    }

    //set livro
}







