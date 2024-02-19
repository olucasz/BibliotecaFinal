package com.biblioteca.dao;

import com.biblioteca.model.Debito;

import java.util.List;

public interface DebitoDAO {
    List<Debito> findByDebitos(String matricula);
    Debito save(Debito debito);
    List<Debito> findAll();
    Debito findById(Long id);
}