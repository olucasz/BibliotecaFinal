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

import com.biblioteca.model.Aluno;
import com.biblioteca.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {


    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.ok(alunoRepository.findAll());
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Aluno> findByMatricula(@PathVariable String matricula) {
        return ResponseEntity.ok(alunoRepository.findByMatricula(matricula));
    }

    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {
        return ResponseEntity.ok(alunoRepository.save(aluno));
    }
 
}
