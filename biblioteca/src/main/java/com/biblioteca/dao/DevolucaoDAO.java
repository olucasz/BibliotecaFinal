package com.biblioteca.dao;

import java.util.List;

import com.biblioteca.model.Devolucao;

public interface DevolucaoDAO {
    Devolucao save(Devolucao devolucao);
    Devolucao findById(Long id);
    Devolucao findByMatricula(int matricula);
    List<Devolucao> findAll();
}