package com.biblioteca.dao;

import com.biblioteca.model.Emprestimo;

import java.util.List;

public interface EmprestimoDAO {
    Emprestimo findById(Long id);
    Emprestimo findByMatricula(String matricula);
    List<Emprestimo> findAll();
    Emprestimo save(Emprestimo emprestimo);
}
